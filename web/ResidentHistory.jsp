<%-- 
    Document   : ResidentHistory
    Created on : Mar 15, 2023, 12:34:37 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./assets/css/global.css">
        <title>Electricity water usage</title>
    </head>
    <body>
        <%
        String account ="";
            if(session.getAttribute("sname") != null){
                account = (String)session.getAttribute("sname");
            }
            
        String roomid ="";
            if(session.getAttribute("roomid") != null){
                roomid = (String)session.getAttribute("roomid");
            }
        %>
        <aside id="logo-sidebar" class="fixed top-0 left-0 z-40 w-64 h-screen transition-transform -translate-x-full sm:translate-x-0 drop-shadow-lg shadow-black" aria-label="Sidebar">
            <div class="h-full w-full px-3 py-4 pt-20 flex flex-col justify-between overflow-y-auto bg-gray-100 dark:bg-gray-800">
                <ul class="space-y-2">
                    <li>
                        <a href="StudentHomePage.jsp" class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-300 dark:hover:bg-gray-700">
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
                        <a href="#" class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white bg-gray-300 dark:bg-gray-700">
                            <span class="w-8 text-center">
                                <i class="fa-solid fa-clock-rotate-left"></i>
                            </span>
                            <span class="flex-1 ml-3 whitespace-nowrap">Resident history</span>
                        </a>
                    </li>
                </ul>
                <form action="logout" method="post">
                    <button type="button" name="logout-button" class="flex items-center justify-center text-center w-full px-3 py-2 text-sm font-medium text-blue-900 bg-blue-300 rounded-lg dark:bg-blue-700 dark:text-blue-100 hover:bg-blue-400 dark:hover:bg-blue-800">Logout</button>
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
        <div class="ml-64 pt-16 h-screen flex items-center justify-center">
            <div class="w-full h-full p-10">
                <div class="w-full h-full">
                    <div class="flex">
                        <div class="w-1/2">
                            <h1 class="font-bold text-3xl text-gray-900 pb-1 mb-8 border-b-2 border-blue-700 inline-block">Recent Room</h1>
                            <!--                            <table>
                                                            <tr>
                                                                <td class="font-bold">StudentID</td>
                                                                <td class="font-bold">RoomID</td>
                                                            </tr>
                                                            
                                                           
                                                        </table>-->
                            <h2>Your Recent Room: <%=roomid%></h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="./assets/script/tailwindcss.js"></script>
        <script src="./assets/fonts/icon/fontawesome.js"></script>
        <style>
            table, tr, th, td {
                border: 2px solid #1e40af;
                border-collapse: collapse;
            }
            th, td {
                padding: 12px;
                text-align: left;
            }
        </style>
    </body>
</html>
