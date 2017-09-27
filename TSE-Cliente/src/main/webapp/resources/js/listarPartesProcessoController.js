//********** implementação do controlador do cliente webservice**********


var listaPartes = [];
var param = "";



$(function() {
	param = location.href.split("?");
	
	var numProcesso = param[1].split('=');
		numProcesso =numProcesso[1];
	carrearGridPartes(numProcesso);
});

function carrearGridPartes(numProcesso) {

	$.ajax({
		type : 'GET',
		url : urlRoot+'/partesPorProcesso/'+numProcesso,
		success : function(partes) {

			listaPartes = partes;
		
			var tableBody = document.getElementById('tablePartes');
			tableBody =$(tableBody);
			var length = listaPartes.length
			
			for (var i = 0; i < length; i++) {
				tableBody.append('<tr><td>' + listaPartes[i].nome + '</td>'
						+ '<td>' + listaPartes[i].cpf +'</td> </tr>');
			}
	
			$(document.getElementById('tablePartes')).append('</table>');
	
		}
	});

}