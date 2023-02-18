<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
<button type="submit" onclick="load()">点击请求</button>
<h2 id="info"></h2>
<script>
    function load() {
        // 1. 创建核心对象
        let xHttp;
        if (window.XMLHttpRequest) {
            xHttp = new XMLHttpRequest();
        } else {
            // for IE6、IE6
            xHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        // 2. 发送请求
        xHttp.open("GET", "http://localhost:9095/ajax");
        xHttp.send();

        // 3. 获取响应
        xHttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                document.getElementById("info").innerHTML = this.responseText
                alert(this.responseText)
            }
        }
    }
</script>
</body>
</html>