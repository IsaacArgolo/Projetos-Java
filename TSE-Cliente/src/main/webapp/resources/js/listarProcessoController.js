//********** implementação do controlador do cliente webservice**********

var listaProcessos = [];

$(function() {
	carrearGridProcessos();
});

function carrearGridProcessos() {

	$.ajax({
		type : 'GET',
		url : urlRoot,
		success : function(processos) {

			listaProcessos = processos;

			var tableBody = $('#tableProcesso').find('tbody');
			var length = listaProcessos.length

			for (var i = 0; i < length; i++) {
				tableBody.append('<tr><td>' + '<a href="http://localhost:8080/TJSE-Cliente/listarPartes.html?numeroProcesso='+listaProcessos[i].numero+'">'
						+ listaProcessos[i].numero + '</a>' + '</td>' + '<td>'
						+ listaProcessos[i].classe.descricao + '<strong>('
						+ listaProcessos[i].classe.codigo + ')</strong>'
						+ '</td>' + '<td>' + listaProcessos[i].situacao
						+ '</td></tr>');
			}
			$('#idTable').append('</table>');

		}
	});

}
