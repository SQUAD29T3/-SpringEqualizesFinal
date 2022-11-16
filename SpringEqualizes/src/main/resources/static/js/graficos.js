
/* TOTAL DE CADASTROS ATIVOS - ESCOLAS / EMPRESAS */

const totalEsc = document.querySelector('#totalEscolas').value;
const escola = parseInt(totalEsc);

const totalEmp = document.querySelector('#totalEmpresas').value;
const empresa = parseInt(totalEmp);


/* TOTAL DE PEDIDOS - ESCOLAS / EMPRESAS */
 
const abertoTotal = document.querySelector('#totalEmAberto').value;
const aberto = parseInt(abertoTotal);

const andamentoTotal = document.querySelector('#totalEmAndamento').value;
const andamento = parseInt(andamentoTotal);

const concluidoTotal = document.querySelector('#totalConcluido').value;
const concluido = parseInt(concluidoTotal)



google.charts.load('current', { 'packages': ['corechart'] });
google.charts.setOnLoadCallback(drawChart,);

function drawChart() {

	var data = google.visualization.arrayToDataTable([
		['Tipo de parceria', 'Total'],
		['Escolas', escola],
		['Empresas', empresa]

	]);

	var dados = google.visualization.arrayToDataTable([
		['Pedidos', 'Total'],
		['Em aberto', aberto],
		['Em andamento', andamento],
		['Concluídos', concluido]
	]);

	var options = {
		title: 'INSTITUIÇÕES PARCEIRAS - CADASTROS REALIZADOS'

	};

	var option = {
		title: 'PEDIDOS REALIZADOS'
	};

// GRÁFICO QUE REPRESENTA AS INSTITUIÇÕES PARCEIRAS
	var chart = new google.visualization.PieChart(document.getElementById('piechart'));
	chart.draw(data, options);

// GRÁFICO QUE REPRESENTA OS PEDIDOS
	var newChart = new google.visualization.PieChart(document.getElementById('piechartPedidos'));
	newChart.draw(dados, option);

}