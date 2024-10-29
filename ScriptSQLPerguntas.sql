USE ecommerce;

-- Q1 
SELECT COUNT(*) AS Total_Clientes
FROM Clientes;

-- Q2
SELECT *
FROM Produtos
WHERE Estoque > 50;

-- Q3
SELECT c.Cliente_ID, c.Nome, COUNT(v.Venda_ID) AS Total_Vendas
FROM Clientes c
LEFT JOIN Vendas v ON c.Cliente_ID = C.Cliente_ID
GROUP BY c.Cliente_ID, c.Nome;

-- Q4
SELECT *
FROM Clientes
WHERE Data_Cadastro >= CURDATE() - INTERVAL 30 DAY;

-- Q5
SELECT c.Nome, e.Cidade
FROM Clientes c
JOIN Enderecos e ON c.Cliente_ID = e.Cliente_ID;

-- Q6
SELECT v.Venda_ID, p.Nome AS Nome_Produto, iv.Quantidade
FROM Itens_Venda iv
JOIN Produtos p ON p.Produto_ID = p.Produto_ID
JOIN Vendas v ON v.Venda_ID = v.Venda_ID;

-- Q7
SELECT c.Nome AS Categoria, SUM(p.Estoque) AS Total_Produtos
FROM Produtos p
JOIN Categorias c ON p.Categoria_ID = c.Categoria_ID
GROUP BY c.Categoria_ID, c.Nome;

-- Q8
SELECT f.Nome AS Fornecedor, SUM(iv.Quantidade) AS Total_Vendidos
FROM Itens_Venda iv
JOIN Produtos p ON p.Produto_ID = p.Produto_ID
JOIN Fornecedores f ON p.Fornecedor_ID = f.Fornecedor_ID
GROUP BY f.Fornecedor_ID, f.Nome;

-- Q9
SELECT v.Data_Venda, SUM(iv.Preco_Unitario * iv.Quantidade) AS Total_Vendas
FROM Vendas v
JOIN Itens_Venda iv ON v.Venda_ID = iv.Venda_ID
GROUP BY v.Data_Venda
ORDER BY v.Data_Venda;

-- Q10
SELECT DISTINCT c.*
FROM Clientes c
JOIN Vendas v ON c.Cliente_ID = c.Cliente_ID
JOIN Status_Pedido s ON s.Status_ID = s.Status_ID
WHERE s.Descricao = 'Pendente';

-- Q11
SELECT c.Nome AS Cliente, p.Nome AS Produto, ca.Quantidade
FROM Carrinho c
JOIN Clientes c ON c.Cliente_ID = c.Cliente_ID
JOIN Produtos p ON p.Produto_ID = p.Produto_ID;

-- Q12
SELECT c.Nome AS Categoria, AVG(p.Preco) AS Preco_Medio
FROM Produtos p
JOIN Categorias c ON p.Categoria_ID = c.Categoria_ID
GROUP BY c.Categoria_ID, c.Nome;

-- Q13
SELECT SUM(iv.Quantidade) AS Total_Produtos_Vendidos
FROM Itens_Venda iv;

-- Q14
SELECT c.Cliente_ID, c.Nome
FROM Clientes c
JOIN Vendas v ON c.Cliente_ID = c.Cliente_ID
GROUP BY c.Cliente_ID, c.Nome
HAVING COUNT(v.Venda_ID) > 3;

-- Q15
SELECT s.Descricao AS Status_Pedido, SUM(iv.Preco_Unitario * iv.Quantidade) AS Total_Vendas
FROM Vendas v
JOIN Itens_Venda iv ON v.Venda_ID = iv.Venda_ID
JOIN Status_Pedido s ON v.Status_ID = s.Status_ID
GROUP BY s.Status_ID, s.Descricao;