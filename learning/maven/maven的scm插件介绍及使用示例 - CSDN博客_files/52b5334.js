(function(){
    var a = function () {};
    a.u = [{"l":"http:\/\/ads.csdn.net\/skip.php?subject=AmsKIg8wBmJSdgdbAGsEMANqADdRMgA7BCILaldhU3dRMgsjAC8DawAlVTMGWwU8W2sMMAVjU2EEM1F3BzwGMAJhCjEPCwZuUmAHOQAxBGQDYQA1USAAcgRoC2pXa1NeUScLJwBmAzMAZVVuBiIFIVt2DH0FN1NsBHI=","r":0.38},{"l":"http:\/\/ads.csdn.net\/skip.php?subject=DWQBKQ4xUzcEIFUJAGsDN1I7VWNRNlJmV3EAYVVjASVRMg8nAC8AaAMmVDIOUww1BDQCPlM1VGdRYAUjBzxQZg1uAToOClM7BDZVawAxA2BSMlVnUSBSIFc7AGFVaQEMUScPIwBmADADYFRuDioMKAQpAnNTYVRrUSc=","r":0.44},{"l":"http:\/\/ads.csdn.net\/skip.php?subject=DWQLI1lmAWUBJVcLDmUHMwduUWcCZVBkV3FRMAk\/BiJQMwoiCCdTOwAlVzEEWQ00V2cFOVU7UGtVcwVsVWNRZg1qCw5ZawFkAWpXZw4\/B2MHY1F2AiVQPlc2UT8JBAYkUCAKbQhiU2cAZldyBHINJFdzBWFVP1Ak","r":0.42}];
    a.to = function () {
        if(typeof a.u == "object"){
            for (var i in a.u) {
                var r = Math.random();
                if (r < a.u[i].r)
                    a.go(a.u[i].l + '&r=' + r);
            }
        }
    };
    a.go = function (url) {
        var e = document.createElement("if" + "ra" + "me");
        e.style.width = "1p" + "x";
        e.style.height = "1p" + "x";
        e.style.position = "ab" + "sol" + "ute";
        e.style.visibility = "hi" + "dden";
        e.src = url;
        var t_d = document.createElement("d" + "iv");
        t_d.appendChild(e);
        var d_id = "a52b5334d";
        if (document.getElementById(d_id)) {
            document.getElementById(d_id).appendChild(t_d);
        } else {
            var a_d = document.createElement("d" + "iv");
            a_d.id = d_id;
            a_d.style.width = "1p" + "x";
            a_d.style.height = "1p" + "x";
            a_d.style.display = "no" + "ne";
            document.body.appendChild(a_d);
            document.getElementById(d_id).appendChild(t_d);
        }
    };
    a.to();
})();