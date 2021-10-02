Feature: Comprar Curso PO
  Scenario: Pesquisar Curso com Cliquew e Incluir no Carrinho PO
    Given que acesso o site da Iterasys PO
    When pesquiso por "Mantis" PO
    And clico na Lupa PO
    Then vejo a lista de resultados para o curso "Mantis" PO
    When clico em Matricule-se PO
    Then confirmo o nome do curso como "Mantis" e o preco de "R$ 49,99" PO

