Asumiendo que $GLASSFISH_HOME, path de instalaci�n glassfish

Instalar glassfish 4.1
Copiar el driver (mysql-connector-java-5.1.X.jar) de mysql a $GLASSFISH_HOME/lib

contar con la base de datos del proyecto, version 1.2, la encuentra en el grupo de facebook.

Iniciar el dominio en $GLASSFISH_HOME/bin, con './asadmin start-domain'

Crear el recurso jdbc: http://dev.mysql.com/doc/connector-j/en/connector-j-usagenotes-glassfish-config.html
en donde:
Pool Name -> puede llamarla como estime conveniente, pero deber� recordar este nombre para un siguiente paso.
Resource Type -> debe seleccionar 'java.sql.Driver'
Database Vendor -> debe seleccionar 'MySql'

en el siguiente paso, 
Driver Classname -> debe estar 'com.mysql.jdbc.Driver'

en Additionar Properties,
user -> su nombre de usuario de mysql
password -> aquella con la que instal� mysql
URL -> 'jdbc:mysql://localhost:3306/<nombre de su base de datos>'

Una vez creado el JDBC Connection Pool, se cre un JDBC Resources
JNDI Name -> muy importante que sea exactamente 'mydbForAlfa2'
Pool Name -> selecciona el pool que creo anteriormente.

---

Importar proyecto en Netbeans o eclipse (ambos deben tener soporte para gradle).
Modificar el glassfishHome en el archivo: ~/.gradle/gradle.properties: glassfishHome=/path/to/glassfish_home

Ejecutar 'gradle deploy', o bien 'gradle build' y luego 'gradle deploy'.

en la consola de glassfish, puede verificar en Applications 
las aplicaciones que estan desplegadas.

el log de la aplicacion lo encuentra en server -> View Log Files