/* Custom javascript primefaces functionalities */



//Función para corregir bug al mostrar las columnas luego de paginar un datatable
function updateToggles(widget) {
	$(widget.jqId + ' .ui-chkbox .ui-chkbox-box').each(function() {
		var chkbox = $(this);
		if (chkbox.hasClass('ui-state-active')) {
			widget.check(chkbox);
		} else {
			widget.uncheck(chkbox);
		}
	});
}