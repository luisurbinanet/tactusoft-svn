window.onbeforeunload = WindowCloseHanlder;

function WindowCloseHanlder()
{
	return "Vas a abandonar esta pagina. Si has hecho algun cambio sin grabar vas a perder todos los datos.";  
}