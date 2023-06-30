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
            if(session.getAttribute("sname") != null){
                account = (String)session.getAttribute("sname");
            }
        %>
        <aside id="logo-sidebar" class="fixed top-0 left-0 z-40 w-64 h-screen transition-transform -translate-x-full sm:translate-x-0 drop-shadow-lg shadow-black" aria-label="Sidebar">
            <div class="h-full w-full px-3 py-4 pt-20 flex flex-col justify-between overflow-y-auto bg-gray-100 dark:bg-gray-800">
                <ul class="space-y-2">
                    <li>
                        <a href="#" class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white bg-gray-300 dark:bg-gray-700">
                            <span class="w-8 text-center">
                                <i class="fa-solid fa-house"></i>
                            </span>
                            <span class="ml-3">Home</span>
                        </a>
                    </li>
                    <li>
                        <a href="ChooseType.jsp" class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-300 dark:hover:bg-gray-700">
                            <span class="w-8 text-center">
                                <i class="fa-solid fa-bed"></i>
                            </span>
                            <span class="flex-1 ml-3 whitespace-nowrap">Booking Bed</span>
                        </a>
                    </li>
                    <li>
                        <a href="Bill.jsp" class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-300 dark:hover:bg-gray-700">
                            <span class="w-8 text-center">
                                <i class="fa-solid fa-plug"></i>
                            </span>
                            <span class="flex-1 ml-3 whitespace-nowrap">Electricity water usage</span>
                        </a>
                    </li>
                    <li>
                        <a href="ResidentHistory.jsp" class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-300 dark:hover:bg-gray-700">
                            <span class="w-8 text-center">
                                <i class="fa-solid fa-clock-rotate-left"></i>
                            </span>
                            <span class="flex-1 ml-3 whitespace-nowrap">Resident history</span>
                        </a>
                    </li>
                </ul>
                <form action="logout" method="post">
                    <input type="submit" name="logout-button" class="flex items-center justify-center text-center w-full px-3 py-2 text-sm font-medium text-blue-900 bg-blue-300 rounded-lg dark:bg-blue-700 dark:text-blue-100 hover:bg-blue-400 dark:hover:bg-blue-800" value="Logout">
                </form>
            </div>
        </aside>
        <header class="fixed top-0 left-0 z-50 h-16 w-full transition-transform -translate-x-full sm:translate-x-0 drop-shadow-lg shadow-black" aria-label="Header"">
            <div class="w-full h-full px-4 flex items-center justify-between bg-gray-100 dark:bg-gray-800">
                <a href="#" class="inline-flex items-center">
                    <img src="https://flowbite.com/docs/images/logo.svg" class="h-6 mr-3 sm:h-7" alt="Flowbite Logo" />
                    <span class="self-center text-xl font-semibold whitespace-nowrap dark:text-white">Campus Dormitory</span>
                </a>
                <div class="flex items-center">
                    <span class="font-semibold text-gray-900 dark:text-white"><%=account%></span>
                    <span class="w-10 h-10 ml-3 flex items-center justify-center text-blue-900 dark:text-blue-100 bg-blue-300 dark:bg-blue-700 rounded-full"><i class="fa-solid fa-user-tie"></i></span>
                </div>
            </div>
        </header>
        <div class="ml-64 h-screen relative flex items-center flex-col">
            <img src="https://ocd.fpt.edu.vn/Content/images/landing/bg3.jpg" alt="Dormitory" class="h-full w-full object-cover absolute top-0 left-0">
            <div class="z-40 absolute top-0 left-0 w-full h-full bg-black/30"></div>
            <h1 class="z-40 absolute flex justify-center mt-32 text-6xl font-bold text-white font-sans drop-shadow-lg shadow-black tracking-widest border-b border-white pb-4 px-4">HOLA CAMPUS</h1>
            <h3 class="z-40 absolute flex justify-center mt-56 text-3xl font-md text-white font-sans drop-shadow-lg shadow-black tracking-widest">DORMITORY MANAGEMENT SYSTEM</h3>
        </div>
        <script src="./assets/script/tailwindcss.js"></script>
        <script src="./assets/fonts/icon/fontawesome.js"></script>
    </body>
</html>