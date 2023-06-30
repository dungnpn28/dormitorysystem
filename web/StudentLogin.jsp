<%-- 
    Document   : StudentLogin
    Created on : Mar 13, 2023, 12:00:45 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./assets/css/global.css">
        <title>Home</title>
    </head>
    <body>
        <%
            String account ="";
            if(request.getAttribute("account") != null){
                account = (String)request.getAttribute("account");
            }
            String password ="";
            if(request.getAttribute("password") != null){
                password = (String)request.getAttribute("password");
            }  
            String noti ="";
            if(request.getAttribute("noti") != null){
                noti = (String)request.getAttribute("noti");
            }
        %>
        <main class="relative">
            <header class="fixed top-0 left-0 z-50 h-16 w-full transition-transform -translate-x-full sm:translate-x-0 drop-shadow-lg shadow-black" aria-label="Header"">
                <div class="w-full h-full px-4 flex items-center justify-between bg-gray-100 dark:bg-gray-800">
                    <a href="#" class="inline-flex items-center">
                        <img src="https://flowbite.com/docs/images/logo.svg" class="h-6 mr-3 sm:h-7" alt="Flowbite Logo" />
                        <span class="self-center text-xl font-semibold whitespace-nowrap dark:text-white">Campus Dormitory</span>
                    </a>
                    <div class="flex items-center">
                        <form action="">
                            <button type="button" onclick="handleLoginPopup()" class="flex items-center justify-center text-center w-full px-5 py-2 font-medium text-blue-900 bg-blue-300 rounded-lg dark:bg-blue-700 dark:text-blue-100 hover:bg-blue-400 dark:hover:bg-blue-800 cursor-pointer">Login</button>
                        </form>
                    </div>
                </div>
            </header>
            <div class="h-screen relative flex items-center flex-col">
                <img src="https://ocd.fpt.edu.vn/Content/images/landing/bg3.jpg" alt="Dormitory" class="h-full w-full object-cover absolute top-0 left-0">
                <div class="z-40 absolute top-0 left-0 w-full h-full bg-black/30"></div>
                <h1 class="z-40 absolute flex justify-center mt-32 text-6xl font-bold text-white font-sans drop-shadow-lg shadow-black tracking-widest border-b border-white pb-4 px-4">HOLA CAMPUS</h1>
                <h3 class="z-40 absolute flex justify-center mt-56 text-3xl font-md text-white font-sans drop-shadow-lg shadow-black tracking-widest">DORMITORY MANAGEMENT SYSTEM</h3>
            </div>
            <div id="login" class="w-full h-screen bg-black/70 z-50 absolute top-0 left-0 flex items-center justify-center opacity-0 hidden transition-all">
                <div class="bg-white inline-block p-10 rounded-xl relative">
                    <a href="#" class="flex items-center justify-center">
                        <img src="https://flowbite.com/docs/images/logo.svg" class="h-6 mr-3 sm:h-7" alt="Flowbite Logo" />
                        <span class="self-center text-3xl font-semibold whitespace-nowrap text-gray-900">Campus Dormitory</span>
                    </a>
                    <form action="studentlogin" method="post" class="mt-8">
                        <div class="mb-4">
                            <label for="username" class="text-gray-900 w-32 inline-block"><i class="fa-solid fa-user-tie w-6 inline-block"></i>Username:</label>
                            <input type="text" id="username" name="account" class="text-gray-900 ring-1 focus:drop-shadow-md shadow-black focus:outline-none focus:ring-blue-800 font-medium rounded-sm text-sm px-4 py-1 ring-blue-500">
                        </div>
                        <div class="mb-8">
                            <label for="password" class="text-gray-900 w-32 inline-block"><i class="fa-solid fa-key w-6 inline-block"></i>Password: </label>
                            <input type="password" name="password" id="password" class="text-gray-900 ring-1 focus:drop-shadow-md shadow-black focus:outline-none focus:ring-blue-800 font-medium rounded-sm text-sm px-4 py-1 ring-blue-500">
                        </div>
                        <input type="submit" value="Login" class="flex items-center justify-center text-center w-full px-5 py-2 font-medium text-blue-900 bg-blue-300 rounded-lg dark:bg-blue-700 dark:text-blue-100 hover:bg-blue-400 dark:hover:bg-blue-800 cursor-pointer">
                    </form>
                    <button onclick="hiddenLogin()" class="absolute top-0 right-0 translate-x-1/2 -translate-y-1/2 w-10 h-10 flex items-center justify-center text-center font-lg text-blue-900 bg-blue-300 rounded-full dark:bg-blue-700 dark:text-blue-100 hover:bg-blue-400 dark:hover:bg-blue-800 cursor-pointer">
                        <i class="fa-solid fa-xmark"></i>
                    </button>
                </div>

            </div>
        </main>
        <script src="./assets/script/tailwindcss.js"></script>
        <script src="./assets/fonts/icon/fontawesome.js"></script>
        <script>
                        document.getElementById("login");
                        function handleLoginPopup() {
                            login.classList.toggle("hidden");
                            setTimeout(() => {
                                login.classList.toggle("opacity-100");
                            }, 50)
                        }
                        function hiddenLogin() {
                            login.classList.toggle("opacity-100");
                            setTimeout(() => {
                                login.classList.toggle("hidden");
                            }, 50)
                        }
        </script>
    </body>
</html>
