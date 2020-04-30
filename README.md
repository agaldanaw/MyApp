# MyApp
Android graphql


#Aspectos a tener en cuenta
- Primero se modifica el build.gradle del proyecto, se agrega lo siguiente:
  - `mavenCentral()` a repositories
  - agregar `classpath "com.apollographql.apollo:apollo-gradle-plugin:2.0.0"` a dependencies
- Luego modificar el build.gradle de la app
  - Agegar `apply plugin: 'com.apollographql.apollo'` al inicio del documento
  - agregar `kotlinOptions { jvmTarget = "1.8" }` a Android
  - agregar `apollo {
        generateKotlinModels.set(true) // or false for Java models
    }` a android
  - agregar ` implementation 'com.apollographql.apollo:apollo-runtime:2.0.0'
    compileOnly("org.jetbrains:annotations:13.0")
    testCompileOnly("org.jetbrains:annotations:13.0")` a dependencies
- Crear carpeta Graphql en src/main. 
- Crear  en src/main/Graphql, en este caso lo llame graphql.apollo
- copiar el Archivo de schema.json de graphql, lo descargar con este comando donde tengan desplegado el api_gateway. `apollo schema:download --endpoint=http://ec2-3-210-210-169.compute-1.amazonaws.com:5000/graphql schema.json`. tienen que tener instaladdo npm y apollo. Se ejecuta desde powershell. Quizás no se pueda ejecutar por algunas directivas de seguridad, ejecuten en la power shell `Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass`
- Crear los archivos .graphql en el paquete con las mutaciones o queries
- Le dan rebuild project y ya deberian poder usar sus queries y mutations de su api gateway
- en MainActivity está la forma como se usa
- Esta app sirve solo mientras yo tenga desplegado el api y encendida la instancia de aws.
- Pueden surgir errores de gradle, de jvn y de versión de kotlin, tener todo actualizado, este proyecto usa la version de gradle 6.4-rc-3 y gradle plugin version 3.6.3. LA versión de JVM es 1.8.
- Aconsejo en la parte  de project, donde aparecen todos los archivos cambiar la vista a Project, por defecto se abre en Android. ESto para crear los archivos y ver la estructura lógica del proyecto y no como lo organiza android studio.
# Cualquier duda me cuentan.

    


