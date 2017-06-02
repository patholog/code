/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2000                    */
/* Created on:     2010-11-3 13:55:55                           */
/*==============================================================*/


alter table leaf
   drop constraint FK_LEAF_RELATIONS_USERS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('leaf')
            and   name  = 'Relationship_1_FK'
            and   indid > 0
            and   indid < 255)
   drop index leaf.Relationship_1_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('leaf')
            and   type = 'U')
   drop table leaf
go

if exists (select 1
            from  sysobjects
           where  id = object_id('users')
            and   type = 'U')
   drop table users
go

/*==============================================================*/
/* Table: leaf                                                  */
/*==============================================================*/
create table leaf (
   lid                  char(32)             not null,
   uid                  int                  null,
   sendfor              varchar(20)          null,
   pdate                datetime             null default getdate(),
   content              varchar(400)         null,
   constraint PK_LEAF primary key nonclustered (lid)
)
go

/*==============================================================*/
/* Index: Relationship_1_FK                                     */
/*==============================================================*/
create index Relationship_1_FK on leaf (
uid ASC
)
go

/*==============================================================*/
/* Table: users                                                 */
/*==============================================================*/
create table users (
   uid                  int                  identity,
   username             varchar(20)          null,
   password             varchar(20)          null,
   constraint PK_USERS primary key nonclustered (uid)
)
go

alter table leaf
   add constraint FK_LEAF_RELATIONS_USERS foreign key (uid)
      references users (uid)
go

