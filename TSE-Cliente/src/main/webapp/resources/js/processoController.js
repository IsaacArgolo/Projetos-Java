//********** implementação do controlador do cliente webservice**********
var listaProcessos = [];

$(function() {

	(function() {
		$.ajax({
			type : 'GET',
			url : urlRoot + "/classes",
			success : function(lista) {
				var sel = $('#idClasses');
				var length = lista.length;

				for (var i = 0; i < length; i++)
					sel.append('<option value="' + lista[i].codigo
							+ '"> ' + lista[i].descricao + "</option>");

			}
		});

		todasPartes();

	})();

});

function salvar() {

	var parte1 = {
		nome : $('#partes1 option:selected').text(),
		cpf : $('#partes1 option:selected').val()

	};

	var parte2 = {
		nome : $('#partes2 option:selected').text(),
		cpf : $('#partes2 option:selected').val()

	};
	//Andamento
	var processo = {
		numero : '',
		situacao : $('#idSituacao option:selected').val(),
		partes : [ parte1, parte2 ],
		classe : {
			codigo : $('#idClasses option:selected').val(),
			descricao : $('#idClasses option:selected').text()
		}
	};

	//processo.classe ={};
	console.log('processo request');
	console.log(processo);
	
	$.ajax({
		type : 'POST',
		dataType : "json",
		contentType : 'application/json',
		data : JSON.stringify(processo),
		url : urlRoot + "/cadastrar",
		success : function(processo) {
			console.log(processo);
		},
		error: function(erro){
			console.log(erro.responseText);
			var arrayErros =erro.responseText.split(',');
			console.log(arrayErros);
			alert(arrayErros[1]);
		}
	});
}

function todasPartes() {

	$.ajax({
		type : 'GET',
		url : urlRoot + "/partes",
		success : function(lista) {
			console.log(lista);
			montarComboPartes("#partes1", lista);
			montarComboPartes("#partes2", lista);
		}
	});
}

function montarComboPartes(id, lista) {
	var sel = $(id);
	var length = lista.length;

	for (var i = 0; i < length; i++)
		sel.append('<option value="' + lista[i].cpf + '"> ' + lista[i].nome
				+ "</option>");
}

function atualiza() {
	var processo;
	$.ajax({
		type : 'PUT',
		data : processo,
		url : urlRoot,
		success : function(p) {
			console.log(p);
			processo = p;
		}
	});
}

function deletar() {
	var processo;
	$.ajax({
		type : 'DELETE',
		url : urlRoot+'/'+'20161000001',
		success : function(p) {
			console.log(p);
			processo = p;
		}
	});
}

// var processo = {
// numero : "20169001458",
// situacao : "Julgado",
// partes : [ {
// nome : "Gabriel O Pensador",
// cpf : "98798798799"
// }, {
// nome : "Juliana Oliveira",
// cpf : "98989898989"
// } ],
// classe : {
// codigo : 190,
// descricao : "Furto Qualificado"
// }
// };
