insert into Genre (id, label) values (1, 'Science-Fiction')
insert into Genre (id, label) values (2, 'Aventure')
insert into Genre (id, label) values (3, 'Horreur')
insert into Genre (id, label) values (4, 'Action')

insert into Format (id, label) values (1, 'DVD')
insert into Format (id, label) values (2, 'Blu-Ray')
insert into Format (id, label) values (3, '1080p')
insert into Format (id, label) values (4, 'Image Disque')

insert into Version (id, location, format_id) values (1, 'Science-Fiction', 1)
insert into Version (id, location, format_id) values (2, 'NAS/Science-Fiction', 3)
insert into Version (id, location, format_id) values (3, 'Horreur', 1)
insert into Version (id, location, format_id) values (4, 'Aventure', 1)

insert into Media (id, title, description) values (1, 'Star Wars - Episode VII', null)
insert into Media (id, title, description) values (2, 'Carrie', 'Date de sortie 	4 décembre 2013 (1h40min) \n Avec 	Chloë Grace Moretz, Julianne Moore, Judy Greer \n Timide et surprotégée par sa mère très pieuse, Carrie est une lycéenne rejetée par ses camarades. Le soir du bal de fin d’année, elle subit une sale blague de trop. Carrie déchaîne alors de terrifiants pouvoirs surnaturels auxquels personne n’échappera…')
insert into Media (id, title, description) values (3, 'Indiana Jones et le Royaume du Crâne de Cristal', 'Date de sortie 	21 mai 2008 (2h3min)   \n Avec 	Harrison Ford, Cate Blanchett, Karen Allen \n La nouvelle aventure d''Indiana Jones débute dans un désert du sud-ouest des Etats-Unis. Nous sommes en 1957, en pleine Guerre Froide. Indy et son copain Mac viennent tout juste d''échapper à une bande d''agents soviétiques à la recherche d''une mystérieuse relique surgie du fond des temps. De retour au Marshall College, le Professeur Jones apprend une très mauvaise nouvelle : ses récentes activités l''ont rendu suspect aux yeux du gouvernement américain. Le doyen Stanforth, qui est aussi un proche ami, se voit contraint de le licencier. A la sortie de la ville, Indiana fait la connaissance d''un jeune motard rebelle, Mutt, qui lui fait une proposition inattendue. En échange de son aide, il le mettra sur la piste du Crâne de Cristal d''Akator, relique mystérieuse qui suscite depuis des siècles autant de fascination que de craintes. Ce serait à coup sûr la plus belle trouvaille de l''histoire de l''archéologie. Indy et Mutt font route vers le Pérou, terre de mystères et de superstitions, où tant d''explorateurs ont trouvé la mort ou sombré dans la folie, à la recherche d''hypothétiques et insaisissables trésors. Mais ils réalisent très vite qu''ils ne sont pas seuls dans leur quête : les agents soviétiques sont eux aussi à la recherche du Crâne de Cristal, car il est dit que celui qui possède le Crâne et en déchiffre les énigmes s''assure du même coup le contrôle absolu de l''univers. Le chef de cette bande est la cruelle et somptueuse Irina Spalko. Indy n''aura jamais d''ennemie plus implacable... Indy et Mutt réuissiront-ils à semer leurs poursuivants, à déjouer les pièges de leurs faux amis et surtout à éviter que le Crâne de Cristal ne tombe entre les mains avides d''Irina et ses sinistres sbires ? ')

insert into Media_Genre (Media_id, genres_id) values (1, 1)
insert into Media_Genre (Media_id, genres_id) values (1, 2)
insert into Media_Genre (Media_id, genres_id) values (2, 3)
insert into Media_Genre (Media_id, genres_id) values (3, 2)
insert into Media_Genre (Media_id, genres_id) values (3, 4)

insert into Media_Version (Media_id, versions_id) values (1, 1)
insert into Media_Version (Media_id, versions_id) values (1, 2)
insert into Media_Version (Media_id, versions_id) values (2, 3)
insert into Media_Version (Media_id, versions_id) values (3, 4)
