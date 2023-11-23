<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
    <title>Alltricks</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Style -->
    <link rel="stylesheet" href="css/style.css">

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

</head>

<body>
    <header>
        <div class="row bg-dark rel py-5 px-2 mx-0">
            <div class=" text-center h1 text-white rel">
                AllTricks - sufiDev
            </div>
            <span>
                <img src="img/logo-white.png" class="abs-img" alt="logo">
            </span>
        </div>
    </header>
    <main>
        <div class="row justify-content-center align-items-center p-3 w-100">
            <div class="col-md-3">
                <form action="Controller?op=vamarca" method="post">
                    <select class="form-select form-select-lg" name="idmarca" id="" onchange="this.form.submit()">
                        <option value="0" disabled selected hidden>Elija Marca</option>
                        <c:forEach items="${marcas}" var="marca">
                        	<option value="${marca.id}">${marca.nombre}</option>
                        </c:forEach>
                    </select>
                </form>
            </div>
            <div class="col-md-3">
                <form action="Controller?op=vaorden" method="post">
                    <select class="form-select form-select-lg" name="orden" id="" onchange="this.form.submit()">
                        <option value="null" disabled selected hidden>Elija Orden</option>
                        <option value="marca">Marca</option>
                        <option value="precio asc">Precio Ascendente</option>
                        <option value="precio desc">Precio Descendente</option>
                    </select>
                </form>
            </div>
            <div class="col-md-3 text-end">
                <span class="star display-5">&#9733;</span>
            </div>
        </div>
        
        <div class="container py-5">
            <div class="row">
        	<c:forEach items="${bicis}" var="bici">
                <!-- 3, 2, 1 cols -->
                <div class="col-md-4 col-sm-6">
                    <div class="card pb-5">
                        <img class="card-img-top" src="${bici.foto}" alt="Title">
                        <div class="card-body">
                            <h4 class="card-title">${bici.nombremarca}</h4>
                            <p class="card-text">${bici.descripcion}</p>
                            <p><strong>&euro;${bici.precio}</strong></p>
                        </div>
                        <c:choose>
	                        <c:when test="${bici.fav==0}">
	                        	<a href="Controller?op=fav"
                            	   class="star-primary text-decoration-none display-6 position-absolute bottom-0 start-0 ms-2 mb-2">
                            	   &#9733;
                        		</a>
	                        </c:when>
	                        <c:when test="${bici.fav==1}">
	                        	<a href="Controller?op=fav"
                            	   class="star-warning text-decoration-none display-6 position-absolute bottom-0 start-0 ms-2 mb-2">
                            	   &#9733;
                        		</a>
	                        </c:when>
                        </c:choose>
                    </div>
                </div>
        	</c:forEach>
            </div>
        </div>
    </main>
    <footer>
        <div class="text-center h1 bg-dark text-white py-4 my-0">
            AllTricks - sufiDev - 2023
        </div>
    </footer>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
        </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
        integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
        </script>
</body>

</html>