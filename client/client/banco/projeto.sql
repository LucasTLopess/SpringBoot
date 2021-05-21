use projeto;

ALTER TABLE cliente MODIFY nome VARCHAR (50);
ALTER TABLE cliente MODIFY bairro VARCHAR (25);
ALTER TABLE cliente MODIFY cep VARCHAR (10);
ALTER TABLE cliente MODIFY cnpj VARCHAR (20);
ALTER TABLE cliente MODIFY email VARCHAR (50);
ALTER TABLE cliente MODIFY telefone VARCHAR (15);
ALTER TABLE cliente MODIFY uf VARCHAR (3);
ALTER TABLE cliente MODIFY logradouro VARCHAR (50);
ALTER TABLE cliente MODIFY cidade VARCHAR (25);
 

insert into cliente
		(nome, email, logradouro, cep, bairro, cidade, uf, telefone, cnpj)
        values	
		("Padaria do Zé","ze@padaria.com.br","Rua W3","69919-769", "Conjunto Tucumã", "Rio Branco","AC",'(29) 22828-7537','30.856.223/0001-16'),
		("Fish pescados","peixe@pescados.com.br","Rua Irlanda","65908-584","Jardim Europa","Imperatriz","MA",'(55)37258-5205','85.600.127/0001-02'),
		("Pneus e Rodas","pneus@tires.com.br","Avenida Maria das Graças","","", "Salvador","BA", '(91) 31767-0210','50.776.826/0001-15'),
		("Cervantes e Filhos","uroque@saraiva.com.br"," Avenida Caiçara", "65910-440","Vila Redenção I", "Imperatriz Maranhão","",'(89) 62918-2490','30.211.784/0001-68'),
		("da Cruz e Associados","ziraldo72@rodrigues.com", "Avenida Belo Horizonte", "76962-171", "Cacoal","","RO",'(60)21700-2884','81.488.951/0001-53'),
		("Pacheco e Toledo Ltda.","aranda.bianca@vega.net.br", "Rua Praia do Moa","69906-636", "Praia do Amapá", "Rio Branco","",'(07) 97351-1951','40.386.647/0001-18'),
		("Pereira e Filhos","beltrao.micaela@salazar.com.br","","","","","",'(82)62557-0258','48.038.464/0001-13'),
		("Valdez-Aranda","miguel64@chaves.com", "Rua Wilde Viana das Neves Filho","69901-438", "Conjunto Guiomard Santos"," Rio Branco","",'(09)14337-5184','87.957.215/0001-83'),
		("Zambrano e das Dores","thalissa.galhardo@dacruz.net.br", "Rua Porto dos GaúchosCPA II", "78055-398", "","Cuiabá", "MT",'(85)67788-4945','36.789.281/0001-50'),
		("Mendes-de Oliveira", "miguel64@vieira.com.br", "Travessa B","", "Alvorada","","RS",'(11)59978-8456','32.248.746/0001-05'),
		("Guerra e Matias","adriano.flores@ortiz.org","Travessa Aquidabã", "49050-820", "Suíssa", "Aracaju", "SE",'(12)68826-7961','85.360.630/0001-20'),
		("Branco e Queirós e Associados","gabriel.fidalgo@maia.org","Quadra Quarenta","67033-890", "Aurá", "Ananindeua","PA", '(05)87686-9295','70.928.498/0001-32'),
		("Leon Comercial Ltda.","helena77@paes.com", "Rua Monte Tabor","", "Cidade de Deus", "Manaus" ,"AM" , '(57)59870-5596','50.597.885/0001-26');