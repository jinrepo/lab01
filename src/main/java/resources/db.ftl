<html>
<head>
</head>
<body>
<h1>Mi Lista de Cursos</h1>

<#list results as curso>
    <div>
        <ul>${curso.id}
            <p>${curso.nivel} ${curso.nombre}</p>
        </ul>
        
    </div>
</#list>

</body>
</html>
