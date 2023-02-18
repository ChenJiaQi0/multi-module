<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>登录页面</title>
</head>
<body>
<div class="container">
    <div class="box">
        <div class="transtion-box">
            <div class="login-box">
                <h1>欢迎回来</h1>
                <form action="login" method="post" class="login-box">
                <section>
                    <label for="account">账号</label>
                    <input type="text" class="account" name="account"/>
                </section>
                <section>
                    <label for="password">密码</label>
                    <input type="password" class="password" name="password"/>
                    <span>忘记密码?</span>
                </section>
                <button type="submit">登录</button>
                <button type="button" class="other">
                    使用<span style="font-weight: 900; color: #455a81">二维码</span
                >扫码登录
                </button>
                </form>
            </div>
            <div class="reg-box" style="display: none">
                <h1>立即注册</h1>
                <form action="register" method="post">
                <section>
                    <label for="username">用户名</label>
                    <input type="text" id="username" name="nickname"/>
                </section>
                <section>
                    <label for="account">账号</label>
                    <input type="text" id="account" name="account"/>
                    <span id="flag"></span>
                </section>
                <section>
                    <label for="password">密码</label>
                    <input type="password" id="password" name="password"/>
                </section>
                <button type="submit">注册</button>
                </form>
                <button type="button" class="other">
                    使用<span style="font-weight: 900; color: #455a81">二维码</span
                >扫码注册
                </button>
            </div>
        </div>
        <div class="transferToReg">
            <h1 class="title">还未注册？</h1>
            <span class="subTitle">立即注册，发现大量机会！</span>
            <button type="button" id="transfetBtn">注册</button>
        </div>
    </div>
</div>
</body>
<script>
    let transfer = document.getElementById('transfetBtn');
    transfer.addEventListener('click', function () {
        let login = document.querySelector('.login-box');
        let reg = document.querySelector('.reg-box');
        let total = document.querySelector('.transtion-box');
        let target = document.querySelector('.transferToReg');
        let title = document.querySelector('.title');
        let subTitle = document.querySelector('.subTitle');
        let account_inp = document.querySelector('.account');
        let password_inp = document.querySelector('.password');
        let flag = document.querySelector('#flag');
        transfer.innerText === '注册'
            ? (() => {
                target.style.left = 0;
                total.style.left = 260 + 'px';
                transfer.innerText = '登录';
                title.innerText = '已有帐号？';
                subTitle.innerText = '有帐号就登录吧，好久不见了！';
                setTimeout(() => {
                    login.style.display = 'none';
                    reg.style.display = 'flex';
                }, 300);
                document.getElementById("username").value="";
                document.getElementById("account").value="";
                document.getElementById("password").value="";
                flag.innerHTML = "";
            })()
            : (() => {
                target.style.left = 640 + 'px';
                total.style.left = 0;
                transfer.innerText = '注册';
                title.innerText = '还未注册？';
                subTitle.innerText = '立即注册，发现大量机会！';
                setTimeout(() => {
                    login.style.display = 'flex';
                    reg.style.display = 'none';
                }, 300);
                account_inp.value="";
                password_inp.value="";
            })();
    });

    let account = document.querySelector('#account');
    account.addEventListener('blur',IfUser);
    function IfUser() {
        let xHttp;
        if (window.XMLHttpRequest) {
            xHttp = new XMLHttpRequest();
        } else {
            // for IE6、IE6
            xHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        // 2. 发送请求
        xHttp.open("GET", "http://localhost:9094/verifi" + '?account=' + account.value);
        xHttp.send();

        // 3. 获取响应
        xHttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                if (xHttp.responseText === 'true'){
                    document.getElementById("flag").innerText = '用户可用';
                    document.getElementById("flag").style.color="green";
                    setTimeout(()=>{
                        document.getElementById("flag").innerText = "";
                    },2000);
                }else{
                    document.getElementById("flag").innerText = '用户已存在';
                    document.getElementById("flag").style.color="red";
                    setTimeout(()=>{
                        document.getElementById("flag").innerText = "";
                    },2000);
                }
            }
        }
    }

</script>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }
    body {
        width: 100%;
        height: 100%;
    }
    .container {
        width: 100%;
        height: 100vh;
        background-color: #ededed;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .container .box {
        width: 900px;
        height: 550px;
        background: #fff;
        border-radius: 4px;
        position: relative;
    }
    .container .box .transtion-box {
        position: absolute;
        left: 0;
        transition: 0.5s all ease-in-out;
    }
    .container .box .transtion-box .login-box,
    .reg-box {
        width: 640px;
        height: 100%;
        display: flex;
        flex-flow: column nowrap;
        align-items: center;
        padding: 50px 30px;
    }

    .container .box .transtion-box h1 {
        margin-bottom: 35px;
    }
    .container .box .transtion-box section {
        display: flex;
        flex-flow: inherit;
        align-items: inherit;
        width: 100%;
        margin-bottom: 30px;
    }
    .container .box .transtion-box section label {
        font-size: 14px;
        color: #909399;
        text-transform: uppercase;
        margin-bottom: 8px;
    }
    .container .box .transtion-box section input {
        width: 50%;
        outline: 0;
        border: none;
        font-size: 18px;
        color: tomato;
        text-align: center;
        padding: 4px 10px;
        border-bottom: 1px solid rgba(0, 0, 0, 0.4);
    }
    .container .box .transtion-box section span {
        color: rgb(80, 80, 77);
        font-size: 15px;
        cursor: pointer;
        margin-top: 18px;
    }
    .container .box .transtion-box button {
        width: 50%;
        padding: 6px 0;
        text-align: center;
        border: 3px solid #d4af7a;
        border-radius: 20px;
        background: #d4af7a;
        color: #fff;
        font-size: 17px;
        letter-spacing: 6px;
        text-indent: 6px;
        margin-bottom: 15px;
        cursor: pointer;
    }
    .container .box .transtion-box .other {
        border: 3px solid #d3dae9;
        background: #fff;
        color: rgb(124, 145, 184);
        font-weight: 600;
    }
    .container .box .transferToReg {
        width: 260px;
        height: 100%;
        background: linear-gradient(
                to bottom right,
                #0e92eb 0%,
                #5f90ec 50%,
                #b08fe5 100%
        );
        border-top-right-radius: 4px;
        border-bottom-right-radius: 4px;
        position: absolute;
        left: 640px;
        top: 0;
        display: flex;
        flex-flow: column nowrap;
        align-items: center;
        padding: 50px 0;
        color: white;
        transition: all 1s ease-in-out;
    }
    .container .box .transferToReg .title {
        margin-bottom: 10px;
        transition: all 0.3s ease-in-out;
    }
    .container .box .transferToReg button {
        margin-top: 260px;
        width: 50%;
        padding: 8px 0;
        border-radius: 14px;
        letter-spacing: 10px;
        text-indent: 10px;
        font-size: 18px;
        color: #fff;
        border: 3px solid #fff;
        background: transparent;
        font-weight: 700;
        cursor: pointer;
    }
    .container .box .transferToReg button:hover {
        border: 3px solid #206dfc;
    }
</style>
</html>
