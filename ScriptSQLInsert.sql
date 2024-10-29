-- Inserindo dados na tabela Clientes
INSERT INTO Clientes (Cliente_ID, Nome, Email, Telefone, Data_Cadastro) VALUES
(1, 'Maria Silva', 'maria.silva@email.com', '11987654321', '2024-10-15'),
(2, 'João Souza', 'joao.souza@email.com', '21987654321', '2024-10-02'),
(3, 'Ana Oliveira', 'ana.oliveira@email.com', '31987654321', '2023-03-05'),
(4, 'Carlos Santos', 'carlos.santos@email.com', '41987654321', '2021-11-30'),
(5, 'Luciana Pereira', 'luciana.pereira@email.com', '51987654321', '2022-01-10');

-- Inserindo dados na tabela Enderecos
INSERT INTO Enderecos (Endereço_ID, Cliente_ID, Rua, Cidade, Estado, CEP) VALUES
(1, 1, 'Rua das Flores', 'São Paulo', 'SP', '01000-000'),
(2, 2, 'Avenida Brasil', 'Rio de Janeiro', 'RJ', '20000-000'),
(3, 3, 'Rua da Paz', 'Belo Horizonte', 'MG', '30000-000'),
(4, 4, 'Rua do Sol', 'Curitiba', 'PR', '80000-000'),
(5, 5, 'Avenida Vitória', 'Vitória', 'ES', '29000-000');

-- Inserindo dados na tabela Categorias
INSERT INTO Categorias (Categoria_ID, Nome, Descricao) VALUES
(1, 'Eletrônicos', 'Produtos eletrônicos de última geração'),
(2, 'Roupas', 'Vestimentas para todas as idades'),
(3, 'Alimentos', 'Alimentos variados e saudáveis'),
(4, 'Móveis', 'Móveis para todos os ambientes'),
(5, 'Livros', 'Literatura nacional e internacional');

-- Inserindo dados na tabela Fornecedores
INSERT INTO Fornecedores (Fornecedor_ID, Nome, Contato, Telefone, Email, Categoria_ID_Fornecedor) VALUES
(1, 'Fornecedor A', 'José da Silva', '11912345678', 'fornecedorA@email.com', 1),
(2, 'Fornecedor B', 'Maria Oliveira', '21912345678', 'fornecedorB@email.com', 2),
(3, 'Fornecedor C', 'Carlos Almeida', '31912345678', 'fornecedorC@email.com', 3),
(4, 'Fornecedor D', 'Luciana Souza', '41912345678', 'fornecedorD@email.com', 4),
(5, 'Fornecedor E', 'Rafael Costa', '51912345678', 'fornecedorE@email.com', 5);

-- Inserindo dados na tabela Produtos
INSERT INTO Produtos (Produto_ID, Nome, Descricao, Preco, Estoque, Categoria_ID, Fornecedor_ID) VALUES
(1, 'Smartphone XYZ', 'Smartphone com tela de 6.5"', 1500.00, 10, 1, 1),
(2, 'Camisa Polo', 'Camisa polo de algodão', 100.00, 50, 2, 2),
(3, 'Biscoitos Sortidos', 'Pacote de biscoitos variados', 5.00, 100, 3, 3),
(4, 'Sofá Retrátil', 'Sofá retrátil de 3 lugares', 2500.00, 5, 4, 4),
(5, 'Livro de Programação', 'Aprenda a programar do zero', 45.00, 30, 5, 5);

-- Inserindo dados na tabela Status_Pedido
INSERT INTO Status_Pedido (Status_ID, Descricao) VALUES
(1, 'Aguardando Pagamento'),
(2, 'Pagamento Confirmado'),
(3, 'Enviado'),
(4, 'Entregue'),
(5, 'Cancelado');

-- Inserindo dados na tabela Vendas
INSERT INTO Vendas (Venda_ID, Cliente_ID_Vendas, Status_ID, Data_Venda) VALUES
(1, 1, 2, '2023-02-01'),
(2, 2, 4, '2023-03-10'),
(3, 3, 1, '2023-04-05'),
(4, 4, 3, '2023-05-15'),
(5, 5, 5, '2023-06-20');

-- Inserindo dados na tabela Pagamentos
INSERT INTO Pagamentos (Pagamento_ID, Venda_ID_Pagamento, Data_Pagamento, Valor_Pago, Metodo_Pagamento) VALUES
(1, 1, '2023-02-01', 1500.00, 'Cartão de Crédito'),
(2, 2, '2023-03-10', 200.00, 'Boleto'),
(3, 3, '2023-04-05', 15.00, 'Transferência'),
(4, 4, '2023-05-15', 2500.00, 'Pix'),
(5, 5, '2023-06-20', 45.00, 'Dinheiro');

-- Inserindo dados na tabela Itens_Venda
INSERT INTO Itens_Venda (Item_ID, Produto_ID_Itens, Venda_ID, Quantidade, Preco_Unitario) VALUES
(1, 1, 1, 1, 1500.00),
(2, 2, 2, 2, 100.00),
(3, 3, 3, 3, 5.00),
(4, 4, 4, 1, 2500.00),
(5, 5, 5, 1, 45.00);

-- Inserindo dados na tabela Carrinho
INSERT INTO Carrinho (Carrinho_ID, Venda_ID_Carrinho, Quantidade) VALUES
(1, 1, 2),
(2, 2, 1);
