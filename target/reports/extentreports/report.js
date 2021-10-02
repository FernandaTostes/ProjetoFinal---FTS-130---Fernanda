$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("comprarCursoPO.feature");
formatter.feature({
  "line": 1,
  "name": "Comprar Curso PO",
  "description": "",
  "id": "comprar-curso-po",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3317433635,
  "status": "passed"
});
formatter.before({
  "duration": 3496081,
  "status": "passed"
});
formatter.scenario({
  "line": 2,
  "name": "Pesquisar Curso com Cliquew e Incluir no Carrinho PO",
  "description": "",
  "id": "comprar-curso-po;pesquisar-curso-com-cliquew-e-incluir-no-carrinho-po",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "que acesso o site da Iterasys PO",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "pesquiso por \"Mantis\" PO",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "clico na Lupa PO",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "vejo a lista de resultados para o curso \"Mantis\" PO",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "clico em Matricule-se PO",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "confirmo o nome do curso como \"Mantis\" e o preco de \"R$ 49,99\" PO",
  "keyword": "Then "
});
formatter.match({
  "location": "comprarCursoPO.queAcessoOSiteDaIterasysPO()"
});
formatter.result({
  "duration": 8296195342,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Mantis",
      "offset": 14
    }
  ],
  "location": "comprarCursoPO.pesquisoPorPO(String)"
});
formatter.result({
  "duration": 553293599,
  "status": "passed"
});
formatter.match({
  "location": "comprarCursoPO.clicoNaLupaPO()"
});
formatter.result({
  "duration": 205287408,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Mantis",
      "offset": 41
    }
  ],
  "location": "comprarCursoPO.vejoAListaDeResultadosParaOCursoPO(String)"
});
formatter.result({
  "duration": 2969925980,
  "status": "passed"
});
formatter.match({
  "location": "comprarCursoPO.clicoEmMatriculeSePO()"
});
formatter.result({
  "duration": 7142684014,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Mantis",
      "offset": 31
    },
    {
      "val": "R$ 49,99",
      "offset": 53
    }
  ],
  "location": "comprarCursoPO.confirmoONomeDoCursoComoEOPrecoDePO(String,String)"
});
formatter.result({
  "duration": 139391338,
  "status": "passed"
});
formatter.after({
  "duration": 148171164,
  "status": "passed"
});
formatter.after({
  "duration": 114858,
  "status": "passed"
});
});