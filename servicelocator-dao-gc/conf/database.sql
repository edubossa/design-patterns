USE `aa`;

CREATE TABLE `cursos` (
  `codigo_curso` int(11) NOT NULL auto_increment,
  `nome` varchar(64) NOT NULL default '',
  `apelido` varchar(8) default NULL,
  `descricao` varchar(255) default NULL,
  `carga_horaria` int(11) NOT NULL default '120',

  PRIMARY KEY  (`codigo_curso`)
) TYPE=MyISAM;

CREATE TABLE `matriculas` (
  `codigo_matricula` int(11) NOT NULL auto_increment,
  `codigo_turma` int(11) NOT NULL default '0',
  `codigo_membership` int(11) NOT NULL default '0',
  `data_matricula` datetime default NULL,
  PRIMARY KEY  (`codigo_matricula`)
) TYPE=MyISAM;


CREATE TABLE `memberships` (
  `codigo_membership` int(11) NOT NULL auto_increment,
  `nome` varchar(255) NOT NULL default '',
  `endereco` varchar(255) default NULL,
  `data_inclusao` datetime NOT NULL,
  PRIMARY KEY  (`codigo_membership`)
) TYPE=MyISAM;

CREATE TABLE `turmas` (
  `codigo_turma` int(11) NOT NULL auto_increment,
  `codigo_curso` int(11) NOT NULL default '0',
  `data_inicio` date default NULL,
  `data_termino` date default NULL,
  `descricao` varchar(255) default NULL,
  `periodo` varchar(16) default NULL,
  `numero_vagas` int(11) NOT NULL default '0',

  PRIMARY KEY  (`codigo_turma`)

) TYPE=MyISAM;

