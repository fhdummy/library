/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     02.12.2015 21:47:28                          */
/*==============================================================*/


drop table if exists BUCH;

drop table if exists CD;

drop table if exists FILM;

drop table if exists KONTO;

drop table if exists KUNDE;

drop table if exists MEDIUM;

drop table if exists REGAL;

/*==============================================================*/
/* Table: BUCH                                                  */
/*==============================================================*/
create table BUCH
(
   MEDIUM_ID            int not null,
   ISBN                 text not null,
   REGAL_ID             int,
   KUNDE_ID             int,
   STARTZEIT            date,
   ENDSOLLZEIT          date,
   ENDISTZEIT           date,
   STRAFE               float,
   TYP                  text not null,
   TITEL                text not null,
   AUTOR                text,
   JAHR                 int,
   primary key (MEDIUM_ID, ISBN)
);

/*==============================================================*/
/* Table: CD                                                    */
/*==============================================================*/
create table CD
(
   MEDIUM_ID            int not null,
   CD_ID                int not null,
   REGAL_ID             int,
   KUNDE_ID             int,
   STARTZEIT            date,
   ENDSOLLZEIT          date,
   ENDISTZEIT           date,
   STRAFE               float,
   TITEL                text not null,
   LAENGE               time,
   INTERPRET            text,
   ALBUM                text,
   JAHR                 int,
   primary key (MEDIUM_ID, CD_ID)
);

/*==============================================================*/
/* Table: FILM                                                  */
/*==============================================================*/
create table FILM
(
   MEDIUM_ID            int not null,
   FILM_ID              int not null,
   REGAL_ID             int,
   KUNDE_ID             int,
   STARTZEIT            date,
   ENDSOLLZEIT          date,
   ENDISTZEIT           date,
   STRAFE               float,
   TITEL                text not null,
   REGISSEUR            text,
   LAENGE               time,
   JAHR                 int,
   primary key (MEDIUM_ID, FILM_ID)
);

/*==============================================================*/
/* Table: KONTO                                                 */
/*==============================================================*/
create table KONTO
(
   KONTO_ID             int not null,
   KUNDE_ID             int not null,
   ISTBETRAG            float not null,
   SOLLBETRAG           float,
   primary key (KONTO_ID)
);

/*==============================================================*/
/* Table: KUNDE                                                 */
/*==============================================================*/
create table KUNDE
(
   KUNDE_ID             int not null,
   KONTO_ID             int,
   VORNAME              text,
   NACHNAME             text,
   STRASSE              text,
   PLZ                  int,
   ORT                  text,
   LAND                 text,
   GEBURTSTAG           date,
   STUDENT              TINYINT,
   primary key (KUNDE_ID)
);

/*==============================================================*/
/* Table: MEDIUM                                                */
/*==============================================================*/
create table MEDIUM
(
   MEDIUM_ID            int not null,
   REGAL_ID             int,
   KUNDE_ID             int,
   STARTZEIT            date,
   ENDSOLLZEIT          date,
   ENDISTZEIT           date,
   STRAFE               float,
   primary key (MEDIUM_ID)
);

/*==============================================================*/
/* Table: REGAL                                                 */
/*==============================================================*/
create table REGAL
(
   REGAL_ID             int not null,
   REIHE                text,
   PLATZ                text,
   MENGE                int,
   primary key (REGAL_ID)
);

alter table BUCH add constraint FK_INHERITANCE_2 foreign key (MEDIUM_ID)
      references MEDIUM (MEDIUM_ID) on delete restrict on update restrict;

alter table CD add constraint FK_INHERITANCE_3 foreign key (MEDIUM_ID)
      references MEDIUM (MEDIUM_ID) on delete restrict on update restrict;

alter table FILM add constraint FK_INHERITANCE_1 foreign key (MEDIUM_ID)
      references MEDIUM (MEDIUM_ID) on delete restrict on update restrict;

alter table KONTO add constraint FK_RELATIONSHIP_4 foreign key (KUNDE_ID)
      references KUNDE (KUNDE_ID) on delete restrict on update restrict;

alter table KUNDE add constraint FK_RELATIONSHIP_3 foreign key (KONTO_ID)
      references KONTO (KONTO_ID) on delete restrict on update restrict;

alter table MEDIUM add constraint FK_RELATIONSHIP_1 foreign key (KUNDE_ID)
      references KUNDE (KUNDE_ID) on delete restrict on update restrict;

alter table MEDIUM add constraint FK_RELATIONSHIP_2 foreign key (REGAL_ID)
      references REGAL (REGAL_ID) on delete restrict on update restrict;

