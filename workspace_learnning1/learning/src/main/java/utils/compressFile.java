package utils;

/**
 * need jar ant
 * 
 * 			<ant.version>1.7.1</ant.version>
 * 
 * 			<dependency>
			    <groupId>org.apache.ant</groupId>
			    <artifactId>ant</artifactId>
			    <version>${ant.version}</version>				
			</dependency>
 * 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

public class compressFile {
	private File zipFile;

	public compressFile(String finalfilepath) throws IOException {
		zipFile = new File(toAbsollutepath(finalfilepath));
	}

	public String toAbsollutepath(String rlpath) {
		return this.getClass().getResource("/").getPath() + rlpath.substring(rlpath.indexOf("/"));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filespth = "src/main/java/com/cdrcb/tmp/exceltmp/warehouse/excel";
		String zipfilepath = "src/main/java/com/cdrcb/tmp/exceltmp/warehouse/zip/资产导出.zip";
		try {
			Long a = System.currentTimeMillis();
			new compressFile(zipfilepath).compressExe(filespth);
			Long b = System.currentTimeMillis();
			System.err.println("压缩时间:" + (b - a) / 1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 传入临时文件夹，
	 * 
	 * @param filespath
	 * @return
	 * @throws Exception
	 */
	public FileInputStream zipFileInputStream(String tmppath) throws Exception {
		this.compressExe(tmppath);
		FileInputStream input = new FileInputStream(zipFile);
		return input;
	}

	/**
	 * 传入需要压缩的文件夹， 使用 ant中的通用压缩工具类
	 * 
	 * @throws Exception
	 */
	public void compressExe(String tmppath) throws Exception {
		File files = new File(toAbsollutepath(tmppath));
		if (!files.exists()) {
			throw new Exception("文件或文件夹不存在");
		}
		Zip zip = new Zip();
		Project pr = new Project();
		// pr.setName("tempcompress");
		zip.setDestFile(zipFile);
		zip.setProject(pr);
		FileSet fileset = new FileSet();
		fileset.setDir(files);
		fileset.setProject(pr);
		zip.addFileset(fileset);
		zip.execute();
	}

	/**
	 * 删除文件 或删除文件下的所有内容
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void deltetmpfile(String path) throws IOException {
		File files = new File(toAbsollutepath(path));
		if (!files.exists()) {
			throw new IOException("文件或文件夹不存在");
		}
		if (files.isDirectory()) {
			File[] fis = files.listFiles();
			for (File f : fis) {
				f.delete();
			}
		} else {
			files.delete();
		}
	}
}
