PGDMP         /                 |         
   financeiro    13.13    13.13 u    V           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            W           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            X           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            Y           1262    16394 
   financeiro    DATABASE     j   CREATE DATABASE financeiro WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE financeiro;
                postgres    false            �            1259    16395    acesso    TABLE     �   CREATE TABLE public.acesso (
    id integer NOT NULL,
    nome character varying(60),
    login character varying(10),
    senha character varying(8),
    permissao character varying(18)
);
    DROP TABLE public.acesso;
       public         heap    postgres    false            �            1259    16398    acesso_id_seq    SEQUENCE     �   CREATE SEQUENCE public.acesso_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.acesso_id_seq;
       public          postgres    false    200            Z           0    0    acesso_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.acesso_id_seq OWNED BY public.acesso.id;
          public          postgres    false    201            �            1259    16400    bobina    TABLE     �   CREATE TABLE public.bobina (
    id integer NOT NULL,
    nomebobina character varying(60) NOT NULL,
    valorbobina numeric(10,2) NOT NULL
);
    DROP TABLE public.bobina;
       public         heap    postgres    false            �            1259    16403    bobina_id_seq    SEQUENCE     �   CREATE SEQUENCE public.bobina_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.bobina_id_seq;
       public          postgres    false    202            [           0    0    bobina_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.bobina_id_seq OWNED BY public.bobina.id;
          public          postgres    false    203            �            1259    16405    boletoempresa    TABLE     g  CREATE TABLE public.boletoempresa (
    id integer NOT NULL,
    nomeboletoreceber character varying(60),
    databoletoreceber date,
    valorboletoreceber numeric(10,2),
    nomeboletoapagar character varying(60),
    databoletoapagar date,
    valorboletoapagar numeric(10,2),
    statuspago character varying(80),
    observacao character varying(130)
);
 !   DROP TABLE public.boletoempresa;
       public         heap    postgres    false            �            1259    16408    boletoempresa_id_seq    SEQUENCE     �   CREATE SEQUENCE public.boletoempresa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.boletoempresa_id_seq;
       public          postgres    false    204            \           0    0    boletoempresa_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.boletoempresa_id_seq OWNED BY public.boletoempresa.id;
          public          postgres    false    205            �            1259    16410    caixa    TABLE     <  CREATE TABLE public.caixa (
    id integer NOT NULL,
    datahora timestamp without time zone DEFAULT date_trunc('MINUTE'::text, CURRENT_TIMESTAMP),
    descricao character varying(100),
    entrada double precision,
    saida double precision,
    saldoanterior double precision,
    saldoatual double precision
);
    DROP TABLE public.caixa;
       public         heap    postgres    false            �            1259    16414    caixa_id_seq    SEQUENCE     �   CREATE SEQUENCE public.caixa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.caixa_id_seq;
       public          postgres    false    206            ]           0    0    caixa_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.caixa_id_seq OWNED BY public.caixa.id;
          public          postgres    false    207            �            1259    16416    emissornotacliente    TABLE     �  CREATE TABLE public.emissornotacliente (
    id integer NOT NULL,
    idbobina integer,
    datanotaservico timestamp without time zone DEFAULT date_trunc('minute'::text, CURRENT_TIMESTAMP),
    quantproduto integer,
    valorunitario double precision,
    valorpeso double precision,
    cargainicial double precision,
    nomeproduto character varying(60),
    clienteempresa character varying(60),
    idmpresa integer
);
 &   DROP TABLE public.emissornotacliente;
       public         heap    postgres    false            �            1259    16420    calculonf_id_seq    SEQUENCE     �   CREATE SEQUENCE public.calculonf_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.calculonf_id_seq;
       public          postgres    false    208            ^           0    0    calculonf_id_seq    SEQUENCE OWNED BY     N   ALTER SEQUENCE public.calculonf_id_seq OWNED BY public.emissornotacliente.id;
          public          postgres    false    209            �            1259    24622    comissao    TABLE     '  CREATE TABLE public.comissao (
    id integer NOT NULL,
    idempresa integer,
    precocheia double precision,
    precofabrica double precision,
    valorcomissao double precision,
    nome character varying(60),
    empresa character varying(60),
    datapedido date,
    dataentrega date
);
    DROP TABLE public.comissao;
       public         heap    postgres    false            �            1259    24620    comissao_id_seq    SEQUENCE     �   CREATE SEQUENCE public.comissao_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.comissao_id_seq;
       public          postgres    false    229            _           0    0    comissao_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.comissao_id_seq OWNED BY public.comissao.id;
          public          postgres    false    228            �            1259    16422    controlevendedor    TABLE       CREATE TABLE public.controlevendedor (
    id integer NOT NULL,
    nomevenda character varying(60),
    valorvenda double precision,
    datahoravenda timestamp without time zone DEFAULT date_trunc('minute'::text, CURRENT_TIMESTAMP),
    observacao character varying(100)
);
 $   DROP TABLE public.controlevendedor;
       public         heap    postgres    false            �            1259    16426    controlevendedor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.controlevendedor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.controlevendedor_id_seq;
       public          postgres    false    210            `           0    0    controlevendedor_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.controlevendedor_id_seq OWNED BY public.controlevendedor.id;
          public          postgres    false    211            �            1259    16428    emissornotaservico    TABLE     �  CREATE TABLE public.emissornotaservico (
    id integer NOT NULL,
    datanotaservico timestamp without time zone DEFAULT date_trunc('minute'::text, CURRENT_TIMESTAMP),
    clientefornecedor character varying(80),
    cargainicial double precision,
    frete double precision,
    totalfretecarga double precision,
    imposto double precision,
    totalimpostocarga double precision,
    totalcomissao double precision,
    comissao double precision,
    totalfinalcarga double precision
);
 &   DROP TABLE public.emissornotaservico;
       public         heap    postgres    false            �            1259    16432    emissornotaservico_id_seq    SEQUENCE     �   CREATE SEQUENCE public.emissornotaservico_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.emissornotaservico_id_seq;
       public          postgres    false    212            a           0    0    emissornotaservico_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.emissornotaservico_id_seq OWNED BY public.emissornotaservico.id;
          public          postgres    false    213            �            1259    24578    empresa    TABLE       CREATE TABLE public.empresa (
    id integer NOT NULL,
    nome character varying(150),
    cnpj character varying(19),
    celular character varying(14),
    uf character varying(2),
    observacao character varying(130),
    cidade character varying(80)
);
    DROP TABLE public.empresa;
       public         heap    postgres    false            �            1259    24576    empresa_id_seq    SEQUENCE     �   CREATE SEQUENCE public.empresa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.empresa_id_seq;
       public          postgres    false    223            b           0    0    empresa_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.empresa_id_seq OWNED BY public.empresa.id;
          public          postgres    false    222            �            1259    24586 	   notabaixa    TABLE     �  CREATE TABLE public.notabaixa (
    id integer NOT NULL,
    idempresa integer,
    idbobina integer,
    quantidade integer,
    valorunitario double precision,
    pesopapel double precision,
    totalsipi double precision,
    totalcipi double precision,
    valoripi double precision,
    ipi double precision,
    nomeproduto character varying(60),
    nomeempresa character varying(60),
    diferencial double precision,
    dataentrega date,
    datapedido date
);
    DROP TABLE public.notabaixa;
       public         heap    postgres    false            �            1259    24584    notabaixa_id_seq    SEQUENCE     �   CREATE SEQUENCE public.notabaixa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.notabaixa_id_seq;
       public          postgres    false    225            c           0    0    notabaixa_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.notabaixa_id_seq OWNED BY public.notabaixa.id;
          public          postgres    false    224            �            1259    24604 	   notacheia    TABLE     �  CREATE TABLE public.notacheia (
    id integer NOT NULL,
    idempresa integer,
    idbobina integer,
    quantidade integer,
    valorunitario double precision,
    pesopapel double precision,
    totalsipi double precision,
    totalcipi double precision,
    valoripi double precision,
    ipi double precision,
    nomeproduto character varying(60),
    nomeempresa character varying(60),
    diferencial double precision,
    datapedido date,
    dataentrega date
);
    DROP TABLE public.notacheia;
       public         heap    postgres    false            �            1259    24602    notacheia_id_seq    SEQUENCE     �   CREATE SEQUENCE public.notacheia_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.notacheia_id_seq;
       public          postgres    false    227            d           0    0    notacheia_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.notacheia_id_seq OWNED BY public.notacheia.id;
          public          postgres    false    226            �            1259    16434    notaservico    TABLE     $  CREATE TABLE public.notaservico (
    id integer NOT NULL,
    datahora timestamp without time zone DEFAULT date_trunc('minute'::text, CURRENT_TIMESTAMP),
    prestador character varying(100),
    tomador character varying(100),
    descricao character varying(100),
    quantidade integer,
    precoproduto double precision,
    pesoproduto double precision,
    totalproduto double precision,
    freteproduto double precision,
    impostoproduto double precision,
    apagarproduto double precision,
    comissaoproduto character varying(15)
);
    DROP TABLE public.notaservico;
       public         heap    postgres    false            �            1259    16438    notaservico_id_seq    SEQUENCE     �   CREATE SEQUENCE public.notaservico_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.notaservico_id_seq;
       public          postgres    false    214            e           0    0    notaservico_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.notaservico_id_seq OWNED BY public.notaservico.id;
          public          postgres    false    215            �            1259    16440    pagamentofabrica    TABLE        CREATE TABLE public.pagamentofabrica (
    id integer NOT NULL,
    nomepagamento character varying(60),
    valorpagamento double precision,
    datahorapagamento timestamp without time zone DEFAULT date_trunc('minute'::text, CURRENT_TIMESTAMP),
    observacao character varying(100)
);
 $   DROP TABLE public.pagamentofabrica;
       public         heap    postgres    false            �            1259    16444    pagamentofabrica_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pagamentofabrica_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.pagamentofabrica_id_seq;
       public          postgres    false    216            f           0    0    pagamentofabrica_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.pagamentofabrica_id_seq OWNED BY public.pagamentofabrica.id;
          public          postgres    false    217            �            1259    16446    pedidocomprabobina    TABLE     �  CREATE TABLE public.pedidocomprabobina (
    id integer NOT NULL,
    idbobina integer,
    descricao character varying(60),
    datapedido timestamp without time zone DEFAULT date_trunc('MINUTE'::text, CURRENT_TIMESTAMP),
    quantidade integer,
    pesopapel double precision,
    valorunitario double precision,
    totalpedido double precision,
    nomeempresa character varying(80),
    acumulo double precision
);
 &   DROP TABLE public.pedidocomprabobina;
       public         heap    postgres    false            �            1259    16450    pedido_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pedido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.pedido_id_seq;
       public          postgres    false    218            g           0    0    pedido_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.pedido_id_seq OWNED BY public.pedidocomprabobina.id;
          public          postgres    false    219            �            1259    16452    pedidobobina    TABLE     �  CREATE TABLE public.pedidobobina (
    id integer NOT NULL,
    nomecliente character varying(60),
    valorpedido double precision,
    quantidadebobina integer,
    datapedido date,
    dataentrega date,
    observacao character varying(80),
    pagpedido character varying,
    numerochequea character varying(10),
    numerochequeb character varying(10),
    numerochequec character varying(10),
    datahora timestamp without time zone DEFAULT date_trunc('MINUTE'::text, CURRENT_TIMESTAMP)
);
     DROP TABLE public.pedidobobina;
       public         heap    postgres    false            �            1259    16458    pedidobobina_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pedidobobina_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.pedidobobina_id_seq;
       public          postgres    false    220            h           0    0    pedidobobina_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.pedidobobina_id_seq OWNED BY public.pedidobobina.id;
          public          postgres    false    221            w           2604    16460 	   acesso id    DEFAULT     f   ALTER TABLE ONLY public.acesso ALTER COLUMN id SET DEFAULT nextval('public.acesso_id_seq'::regclass);
 8   ALTER TABLE public.acesso ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    201    200            x           2604    16461 	   bobina id    DEFAULT     f   ALTER TABLE ONLY public.bobina ALTER COLUMN id SET DEFAULT nextval('public.bobina_id_seq'::regclass);
 8   ALTER TABLE public.bobina ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202            y           2604    16462    boletoempresa id    DEFAULT     t   ALTER TABLE ONLY public.boletoempresa ALTER COLUMN id SET DEFAULT nextval('public.boletoempresa_id_seq'::regclass);
 ?   ALTER TABLE public.boletoempresa ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204            {           2604    16463    caixa id    DEFAULT     d   ALTER TABLE ONLY public.caixa ALTER COLUMN id SET DEFAULT nextval('public.caixa_id_seq'::regclass);
 7   ALTER TABLE public.caixa ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    207    206            �           2604    24625    comissao id    DEFAULT     j   ALTER TABLE ONLY public.comissao ALTER COLUMN id SET DEFAULT nextval('public.comissao_id_seq'::regclass);
 :   ALTER TABLE public.comissao ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    228    229    229                       2604    16464    controlevendedor id    DEFAULT     z   ALTER TABLE ONLY public.controlevendedor ALTER COLUMN id SET DEFAULT nextval('public.controlevendedor_id_seq'::regclass);
 B   ALTER TABLE public.controlevendedor ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    211    210            }           2604    16465    emissornotacliente id    DEFAULT     u   ALTER TABLE ONLY public.emissornotacliente ALTER COLUMN id SET DEFAULT nextval('public.calculonf_id_seq'::regclass);
 D   ALTER TABLE public.emissornotacliente ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    208            �           2604    16466    emissornotaservico id    DEFAULT     ~   ALTER TABLE ONLY public.emissornotaservico ALTER COLUMN id SET DEFAULT nextval('public.emissornotaservico_id_seq'::regclass);
 D   ALTER TABLE public.emissornotaservico ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    213    212            �           2604    24581 
   empresa id    DEFAULT     h   ALTER TABLE ONLY public.empresa ALTER COLUMN id SET DEFAULT nextval('public.empresa_id_seq'::regclass);
 9   ALTER TABLE public.empresa ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    223    222    223            �           2604    24589    notabaixa id    DEFAULT     l   ALTER TABLE ONLY public.notabaixa ALTER COLUMN id SET DEFAULT nextval('public.notabaixa_id_seq'::regclass);
 ;   ALTER TABLE public.notabaixa ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    225    225            �           2604    24607    notacheia id    DEFAULT     l   ALTER TABLE ONLY public.notacheia ALTER COLUMN id SET DEFAULT nextval('public.notacheia_id_seq'::regclass);
 ;   ALTER TABLE public.notacheia ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    226    227    227            �           2604    16467    notaservico id    DEFAULT     p   ALTER TABLE ONLY public.notaservico ALTER COLUMN id SET DEFAULT nextval('public.notaservico_id_seq'::regclass);
 =   ALTER TABLE public.notaservico ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    214            �           2604    16468    pagamentofabrica id    DEFAULT     z   ALTER TABLE ONLY public.pagamentofabrica ALTER COLUMN id SET DEFAULT nextval('public.pagamentofabrica_id_seq'::regclass);
 B   ALTER TABLE public.pagamentofabrica ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    217    216            �           2604    16469    pedidobobina id    DEFAULT     r   ALTER TABLE ONLY public.pedidobobina ALTER COLUMN id SET DEFAULT nextval('public.pedidobobina_id_seq'::regclass);
 >   ALTER TABLE public.pedidobobina ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    221    220            �           2604    16470    pedidocomprabobina id    DEFAULT     r   ALTER TABLE ONLY public.pedidocomprabobina ALTER COLUMN id SET DEFAULT nextval('public.pedido_id_seq'::regclass);
 D   ALTER TABLE public.pedidocomprabobina ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    219    218            6          0    16395    acesso 
   TABLE DATA           C   COPY public.acesso (id, nome, login, senha, permissao) FROM stdin;
    public          postgres    false    200   ��       8          0    16400    bobina 
   TABLE DATA           =   COPY public.bobina (id, nomebobina, valorbobina) FROM stdin;
    public          postgres    false    202   ��       :          0    16405    boletoempresa 
   TABLE DATA           �   COPY public.boletoempresa (id, nomeboletoreceber, databoletoreceber, valorboletoreceber, nomeboletoapagar, databoletoapagar, valorboletoapagar, statuspago, observacao) FROM stdin;
    public          postgres    false    204   N�       <          0    16410    caixa 
   TABLE DATA           c   COPY public.caixa (id, datahora, descricao, entrada, saida, saldoanterior, saldoatual) FROM stdin;
    public          postgres    false    206   )�       S          0    24622    comissao 
   TABLE DATA           �   COPY public.comissao (id, idempresa, precocheia, precofabrica, valorcomissao, nome, empresa, datapedido, dataentrega) FROM stdin;
    public          postgres    false    229   J�       @          0    16422    controlevendedor 
   TABLE DATA           `   COPY public.controlevendedor (id, nomevenda, valorvenda, datahoravenda, observacao) FROM stdin;
    public          postgres    false    210   B�       >          0    16416    emissornotacliente 
   TABLE DATA           �   COPY public.emissornotacliente (id, idbobina, datanotaservico, quantproduto, valorunitario, valorpeso, cargainicial, nomeproduto, clienteempresa, idmpresa) FROM stdin;
    public          postgres    false    208   �       B          0    16428    emissornotaservico 
   TABLE DATA           �   COPY public.emissornotaservico (id, datanotaservico, clientefornecedor, cargainicial, frete, totalfretecarga, imposto, totalimpostocarga, totalcomissao, comissao, totalfinalcarga) FROM stdin;
    public          postgres    false    212   ޢ       M          0    24578    empresa 
   TABLE DATA           R   COPY public.empresa (id, nome, cnpj, celular, uf, observacao, cidade) FROM stdin;
    public          postgres    false    223   ��       O          0    24586 	   notabaixa 
   TABLE DATA           �   COPY public.notabaixa (id, idempresa, idbobina, quantidade, valorunitario, pesopapel, totalsipi, totalcipi, valoripi, ipi, nomeproduto, nomeempresa, diferencial, dataentrega, datapedido) FROM stdin;
    public          postgres    false    225   V�       Q          0    24604 	   notacheia 
   TABLE DATA           �   COPY public.notacheia (id, idempresa, idbobina, quantidade, valorunitario, pesopapel, totalsipi, totalcipi, valoripi, ipi, nomeproduto, nomeempresa, diferencial, datapedido, dataentrega) FROM stdin;
    public          postgres    false    227   ��       D          0    16434    notaservico 
   TABLE DATA           �   COPY public.notaservico (id, datahora, prestador, tomador, descricao, quantidade, precoproduto, pesoproduto, totalproduto, freteproduto, impostoproduto, apagarproduto, comissaoproduto) FROM stdin;
    public          postgres    false    214   �       F          0    16440    pagamentofabrica 
   TABLE DATA           l   COPY public.pagamentofabrica (id, nomepagamento, valorpagamento, datahorapagamento, observacao) FROM stdin;
    public          postgres    false    216   ��       J          0    16452    pedidobobina 
   TABLE DATA           �   COPY public.pedidobobina (id, nomecliente, valorpedido, quantidadebobina, datapedido, dataentrega, observacao, pagpedido, numerochequea, numerochequeb, numerochequec, datahora) FROM stdin;
    public          postgres    false    220   r�       H          0    16446    pedidocomprabobina 
   TABLE DATA           �   COPY public.pedidocomprabobina (id, idbobina, descricao, datapedido, quantidade, pesopapel, valorunitario, totalpedido, nomeempresa, acumulo) FROM stdin;
    public          postgres    false    218   t�       i           0    0    acesso_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.acesso_id_seq', 18, true);
          public          postgres    false    201            j           0    0    bobina_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.bobina_id_seq', 34, true);
          public          postgres    false    203            k           0    0    boletoempresa_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.boletoempresa_id_seq', 30, true);
          public          postgres    false    205            l           0    0    caixa_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.caixa_id_seq', 90, true);
          public          postgres    false    207            m           0    0    calculonf_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.calculonf_id_seq', 20, true);
          public          postgres    false    209            n           0    0    comissao_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.comissao_id_seq', 7, true);
          public          postgres    false    228            o           0    0    controlevendedor_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.controlevendedor_id_seq', 97, true);
          public          postgres    false    211            p           0    0    emissornotaservico_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.emissornotaservico_id_seq', 7, true);
          public          postgres    false    213            q           0    0    empresa_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.empresa_id_seq', 41, true);
          public          postgres    false    222            r           0    0    notabaixa_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.notabaixa_id_seq', 5, true);
          public          postgres    false    224            s           0    0    notacheia_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.notacheia_id_seq', 49, true);
          public          postgres    false    226            t           0    0    notaservico_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.notaservico_id_seq', 16, true);
          public          postgres    false    215            u           0    0    pagamentofabrica_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.pagamentofabrica_id_seq', 24, true);
          public          postgres    false    217            v           0    0    pedido_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.pedido_id_seq', 1, false);
          public          postgres    false    219            w           0    0    pedidobobina_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.pedidobobina_id_seq', 131, true);
          public          postgres    false    221            �           2606    16472    acesso acesso_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.acesso
    ADD CONSTRAINT acesso_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.acesso DROP CONSTRAINT acesso_pkey;
       public            postgres    false    200            �           2606    16474    bobina bobina_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.bobina
    ADD CONSTRAINT bobina_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.bobina DROP CONSTRAINT bobina_pkey;
       public            postgres    false    202            �           2606    16476     boletoempresa boletoempresa_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.boletoempresa
    ADD CONSTRAINT boletoempresa_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.boletoempresa DROP CONSTRAINT boletoempresa_pkey;
       public            postgres    false    204            �           2606    16478    caixa caixa_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.caixa
    ADD CONSTRAINT caixa_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.caixa DROP CONSTRAINT caixa_pkey;
       public            postgres    false    206            �           2606    16480 !   emissornotacliente calculonf_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.emissornotacliente
    ADD CONSTRAINT calculonf_pkey PRIMARY KEY (id);
 K   ALTER TABLE ONLY public.emissornotacliente DROP CONSTRAINT calculonf_pkey;
       public            postgres    false    208            �           2606    24627    comissao comissao_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.comissao
    ADD CONSTRAINT comissao_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.comissao DROP CONSTRAINT comissao_pkey;
       public            postgres    false    229            �           2606    16482 &   controlevendedor controlevendedor_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.controlevendedor
    ADD CONSTRAINT controlevendedor_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.controlevendedor DROP CONSTRAINT controlevendedor_pkey;
       public            postgres    false    210            �           2606    16484 *   emissornotaservico emissornotaservico_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.emissornotaservico
    ADD CONSTRAINT emissornotaservico_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.emissornotaservico DROP CONSTRAINT emissornotaservico_pkey;
       public            postgres    false    212            �           2606    24583    empresa empresa_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.empresa
    ADD CONSTRAINT empresa_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.empresa DROP CONSTRAINT empresa_pkey;
       public            postgres    false    223            �           2606    24591    notabaixa notabaixa_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.notabaixa
    ADD CONSTRAINT notabaixa_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.notabaixa DROP CONSTRAINT notabaixa_pkey;
       public            postgres    false    225            �           2606    24609    notacheia notacheia_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.notacheia
    ADD CONSTRAINT notacheia_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.notacheia DROP CONSTRAINT notacheia_pkey;
       public            postgres    false    227            �           2606    16486    notaservico notaservico_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.notaservico
    ADD CONSTRAINT notaservico_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.notaservico DROP CONSTRAINT notaservico_pkey;
       public            postgres    false    214            �           2606    16488 &   pagamentofabrica pagamentofabrica_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.pagamentofabrica
    ADD CONSTRAINT pagamentofabrica_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.pagamentofabrica DROP CONSTRAINT pagamentofabrica_pkey;
       public            postgres    false    216            �           2606    16490    pedidocomprabobina pedido_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.pedidocomprabobina
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.pedidocomprabobina DROP CONSTRAINT pedido_pkey;
       public            postgres    false    218            �           2606    16492    pedidobobina pedidobobina_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.pedidobobina
    ADD CONSTRAINT pedidobobina_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.pedidobobina DROP CONSTRAINT pedidobobina_pkey;
       public            postgres    false    220            �           2606    16493 *   emissornotacliente calculonf_idbobina_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.emissornotacliente
    ADD CONSTRAINT calculonf_idbobina_fkey FOREIGN KEY (idbobina) REFERENCES public.bobina(id);
 T   ALTER TABLE ONLY public.emissornotacliente DROP CONSTRAINT calculonf_idbobina_fkey;
       public          postgres    false    202    2961    208            �           2606    24628     comissao comissao_idempresa_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.comissao
    ADD CONSTRAINT comissao_idempresa_fkey FOREIGN KEY (idempresa) REFERENCES public.empresa(id) ON UPDATE CASCADE ON DELETE CASCADE;
 J   ALTER TABLE ONLY public.comissao DROP CONSTRAINT comissao_idempresa_fkey;
       public          postgres    false    2981    229    223            �           2606    24633 3   emissornotacliente emissornotacliente_idmpresa_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.emissornotacliente
    ADD CONSTRAINT emissornotacliente_idmpresa_fkey FOREIGN KEY (idmpresa) REFERENCES public.empresa(id) ON UPDATE CASCADE ON DELETE CASCADE;
 ]   ALTER TABLE ONLY public.emissornotacliente DROP CONSTRAINT emissornotacliente_idmpresa_fkey;
       public          postgres    false    223    2981    208            �           2606    24597 !   notabaixa notabaixa_idbobina_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.notabaixa
    ADD CONSTRAINT notabaixa_idbobina_fkey FOREIGN KEY (idbobina) REFERENCES public.bobina(id) ON UPDATE CASCADE ON DELETE CASCADE;
 K   ALTER TABLE ONLY public.notabaixa DROP CONSTRAINT notabaixa_idbobina_fkey;
       public          postgres    false    225    202    2961            �           2606    24592 "   notabaixa notabaixa_idempresa_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.notabaixa
    ADD CONSTRAINT notabaixa_idempresa_fkey FOREIGN KEY (idempresa) REFERENCES public.empresa(id) ON UPDATE CASCADE ON DELETE CASCADE;
 L   ALTER TABLE ONLY public.notabaixa DROP CONSTRAINT notabaixa_idempresa_fkey;
       public          postgres    false    2981    223    225            �           2606    24615 !   notacheia notacheia_idbobina_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.notacheia
    ADD CONSTRAINT notacheia_idbobina_fkey FOREIGN KEY (idbobina) REFERENCES public.bobina(id) ON UPDATE CASCADE ON DELETE CASCADE;
 K   ALTER TABLE ONLY public.notacheia DROP CONSTRAINT notacheia_idbobina_fkey;
       public          postgres    false    227    202    2961            �           2606    24610 "   notacheia notacheia_idempresa_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.notacheia
    ADD CONSTRAINT notacheia_idempresa_fkey FOREIGN KEY (idempresa) REFERENCES public.empresa(id) ON UPDATE CASCADE ON DELETE CASCADE;
 L   ALTER TABLE ONLY public.notacheia DROP CONSTRAINT notacheia_idempresa_fkey;
       public          postgres    false    227    2981    223            �           2606    16498 '   pedidocomprabobina pedido_idbobina_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.pedidocomprabobina
    ADD CONSTRAINT pedido_idbobina_fkey FOREIGN KEY (idbobina) REFERENCES public.bobina(id) ON UPDATE CASCADE ON DELETE CASCADE;
 Q   ALTER TABLE ONLY public.pedidocomprabobina DROP CONSTRAINT pedido_idbobina_fkey;
       public          postgres    false    2961    202    218            6   J   x�34��IM��)���LL����44�4�t13�K�S�-8sR+�R�R9]8�LM8��sKs�b���� ��:      8   ?  x�m��n�0E��W�*��lS��
u�m7n�j�R�J����`���̽3w:دq6��������� Qq�y����(�b��D%:�Hޯ��NBNS@*CzEz�y�_��Py����+d4���Jz��s�� ���6�\��B頊��&Q�$l�B��c�,>?��Lp�AYe��������R��b�`Ƈ!{����i�8qQc�"�9��zh@����0&��_b�Ei��"8��)�
�O�2�k���i�:�0�K�m1���T
f}6�#�^JBO�ء�OQU���m�]����Ye�I�Ya����      :   �  x����n�0���S�@�؀}̦��J�Zi{��M�,��$ҾT��/��BJ]��V� ���?�߃
����Ku�N��juGL�k}4mG )���)@Y�Lr����'S_c�s�g��_�6�ʶ���m���@)Ŕ��S`�=��ȣ�mw��lFKY~]�������,$������!g����w਋���˄DOƋ�_�kȮ;�!��Վ�&��ge1�S��|H���?	+Vw���S�5y�/ן\1�e��4��#��o�m{��>�G�G��y~��(O�����C��k��N���9�|^�GLg\dJ}�_͖���s�ט7,+���˜-V��{@�g���+١�l��*ʌ/�{�s�2�svxY��2�٢���Q6ʸn�oҽ9^�;x�Y�Sucڳ�"��c��:�d�cl>��uȱ�o_�.W�8�dl�f^�^��'��gA�Dʒ$��'�      <     x�mVK��8\ӧ�� �>Ԯ���g�g������,�c<י�0����I �#jS��^f�� )H���/
�09���(��n:O�ˊ���O��J�U��Fy�~�נ��Z�i �_�^���xV�� )�`;����<.RB���Y�U�Nۋ(�R*����?۴������r@����� uB���V'5�i?I�i��v��I�-Y��
P�N���Қ��m���rQ.<�Wƈ�ƞ�Z�k�tu��GBR�2��4H=J}RHe�HtK��N���9�RJJs�U
�����ԷZ��e W8h@莆�[��<���9C�Tn�����ݙ9yyZn��I�U��KGGy2�Q�Wa��$�r)I�F"����4�B����V�H��[ ��FF'���g�C�D΂'��+�Qv� ��$��UEtITd� I��ǃ���I�Wèƶ����2�����L�q�P��H�
A�p1��n��z����PH��e�T_&[O�)�����IZ����Uz�hk	O}+x�۾m�AFHrI��|o��:Z9��;����+RBLiPo�����p�B���^�x@�@������\]ceJ���&)K�chUB#>���#��d��h�"J��Ec88��W'7��7OfY4��v4p���3�/�	L���.���qā�8���ǆ��DJ��ݷ�E��S����E�
��9�����޿��G�T����>xK@1�����0_���#��$�����n�m�iJ�Oz/�@��y���7U	�lM�'}�_\ɢΫ��;?PƦK��X�Y�&+�~D��������%�S
�Q.f~!���P��s��Ƶ����7��)C�V�Go��-|7h4Z��&��uY���2�̟0T��NI�2��D�*%��#X�=�}l3�Yη.4�-b���̹�َ(�ܛu��5ǂ�X'F�nk.�l�OD	�MO���gj��)���۞U\ �0f���bG_I���f����:_�ɧ����5��      S   �   x��пj�0�Y~
��	[�%{<�nm9J�[�����$}�&�%-�TM� ~���X!��"�`( Qp(����:�Y?���˷2�pnڱ/S[Gdȟ�=Y9bR~�=�!�K6�e������G��.0:�KB�(�B�����<�>�i��o8Y��6��0��H�K�mW��!?�(�Y%g����-�тx�+�i�Bݔ�E}��]���_>��z꾴����H]Q)��ap�      @   �  x��XKr�F]O1jz��N�첝PqI��F�	ɐ@�P��:Y� �X$4�l��{���~�{���!�)+�z]�R��L
�.�����K3��_��)�.C��(��P�[�fS�ی?7%$X�E^��g�!�ЂA�/k�%����lB^ֱ�jwC�|E��;#����q4�O@S���o�:�a�3�J���j��7���-C���-c�n���J�}P wh?����<-ؗ�k&�6��$A�t��u�_��l�K�\M��8��M����ObJ[}?Qn0�AB_ı�E���G $�>Ƴ����z�7a���OL�ؔ}�_�_V�^�����%�^�ĐQ�A���Mɀ$��?��*��>a1������/B�̊���j��(v�˰�Rq��RG�x�:x���D!��=A���j[J	�\I[��:o+qr�@S<���d52V�2�࿛/��*e�;er啥8JD�u�$&%	���C�wх�7�� �R�u�5�ȁ�A��:v���	h�T�����	6�"mi�c��|�5�P���͋�����m�룹N&~Վ �c
�b~���t8z���޼�J���i�`F�U�3#�|j5�a}&�ȴ6�6o��ch�2���:,�mӠ\��PW�&+fz��G��?ݱ�q��8bB��qD���Eπ7�#������34a1�P�C�[�S\<!�\�:���� i$%����v��r�L��[�&X0ܧ�v=S�'����#�����z�X擽ף#��P�T�?f�k`��wD�q?(�?���/��:c4$:�t��6�G<�I��}e���S����,�e�<
������H`=��>*S�����E�gx�Ve�==a0�߅�{k���~�z�-�����,��؉	��NR�'R�7�(�:+����j�:����e<ڏ���ƿ>��)ҿ�[dO�7����WQ�#��s_��#`?(�����"������δ��l�T�Y�uضS �уM<�?����h*L&:]e��W��iO��hz}���%�d���v�n��i��[Rbx*��C�n�N��e���8G�4b�:�����p� ��r�z�K8�?������,8gF[y$8.�\�=aP��/-ǥ{��X�r����Y��Yg9_Y(9>�������U��2���l�/��y�      >   �  x���An�0E��)� 1C�HJ��Φi� �2�V�XH����v؊T���7�������2h�
��4DE�(V�0hR��Ѭ>��n��������ށ�^�*m�q�%ܢ�3�gf����N{�mp:\B�ű� �SZ�qL����f�Ce�QT!IH�Znǫ��	_w�oX���%�?�sCu�W�P�jS	�WA���q�\\|9���0G,vHr��[֎m}��zl7܎�u�e�����[7èd��)��2�Q7�����&�Z��6�%�)Z�bٰ��#��������{�}�]�9��]'`K5K��x�����6n���
���l{W�(����F��Q|l1y4���	�}c��`W�lr��r���о�.��^x���j��Y�wh%�E&�|F��Ǵְl������i����̪?�UN����{�L�s�$DX�5dj`�.AΕ<��b�P"�      B   �   x�m��
�0���S�V�6k�n�'A��K�Sn�/>�]q*�\����hФ�"U)�J7�"�C��>"��`(�5-K[ga�$�|�C�ˉ0����B�^"N��)��l����HZ���I�vg��5����G��K�x�)`a�'ί���b$װ+�c�����֍ӂs���~fq�B���E�      M   �  x�uV�r�6]�_�U�Yœ ��+nƚjl����	E�|$��N��~�� �j��D{��s�=�]ĝ���[�/}_�vc���ۇ˷Hs�9#L�_)���Y�ƦW�����{�}�hZ����5�ɷ=�I	b�`:��M�2}��;���v�D���a��n�Մ2C聂
�����������}&a���1���^�	BW�J�V�<���=��m�.�2f��������5���Lلl�i8��/�.�O�;Ц�らc�0�����5'��	���UJZ��t9Ox]�~�э��:LM穥��TVɄ�rc�л�uc�4N�G���	P�+b�<+?�YjJa�����e����k?�W�Ώ����b� �����\��N�z���������X�oaU���'���sm�����Ǿ�\�VD��t���
{14�~��c{4w��1͍�.!I[)g�Q;!A,,xQ�\���w�c�cѝ�n�k�+�&�0�23��l)��q��{e����՗�1F(�W);�y�D�]�(˜nb?,ǃ8��!g�\ʗ��<��r��R)%&�t���U��������X��nF�S�4��.�A��1��΁s+"�%��B1}
�+��_�~�1�NI���V���k�r�JSUV%6ͩ� T���1-�>�}�����,^r{
��]Ķ�ͳ ָ�����{�Ǣ�8�(�L�e$5�zM�ܲ/��`\!���/:��I�}��	�D�9���3�}�u�R3ݽG��w���W��r��r�	*�������Ӏej��#�;����±}�&v�}�B�n��6�&<9V  0�ݭ���`ƴd!�
�p�o���|\ �`�"��M�'K��b�mB�
X��fP��v�+\p���|cs�줕�/�� ���6P���
�0^kP�+��`��RN%Oq`��΃��o�h �
Kwt��T�������╔�;q�#�(��и���
�(�u2��7�:�Xi�<z���M�۟ZVX���]���q!?HF��O%gc��2ͪ�X�ج�2�Ѝ�3`�8i���MȥӞ]E�a�$���9�Be������vqZr�k�=pzpP����y�'�H�l��q�"Y�I���u�c"      O     x�uP�n1={�"P,�ُz+-R{�`Z�#1 ��f�Z����o1��;:�H�'�"i�8�lL�v�,h󔿓�7�|N�����>)F�,�S}��F�/�ղnw���v��5����#�d��:3#��!�Jz����&*�v��^���'jO�m:���ܪmʇ���2A
�镤��},�8*�������4l�>e�uIW�ehU�[5	��N�z��ĭl��Z�D��u�����1���N���C���7c�F<��?>6XU��Oz�      Q   {  x��X�nG<�~�~�5���1�s�6r�e%11QH��f_3K-CI!H���~UW/����IFY-NoD%b��&�4��K�hO�ڤD�S?nw�]����������;6�����v����p���ӝn?v�v�����ˇo��hƗņ퍡��#�Ɔ�� �r�kR�l�֙�%���_�c|޻5�]K�M�Q?�o����㩽�v�:E��!�w���GN�A��V��(��E	���a4���v׵#���R�uj卩�/G��)�"8��)!0�LB����Uޟ�u�GE�ϛr�������~�~[o ,)ig3�8"����ڿ���O�&�urs��$��G��j~Q��P���s�[ڨ����C{7��P��.��!������.��Cr8kS���As��r�Y���K�%�P�I��|D?ĩa\ޣH�FCr���0����d ��aW��I#+=�9�Dڗ�4ّ�ׅ�?j��:�5���GA���}�&ѱA4�ǌ�����~A�΍�c��)q��545h�s��
�ī@�7�_�]޴�YHӚ��G1����#P�����p�2�̋G��:��T�:6h��Q�}�pT��hU�),���bӝN���g�� ����>3/gv`�r�o��:{�$0���IX�!�>�K�'^��/���.�8� b|A|9v���ǧm�������4��I)U 7�M��}�)�,�ey���N/)�s댙�v.�z�=���Q����i����&�/�q�
��`r�TߗΟ0D���"%�;��#�0  ������&�Z%��J��G�=�-�ٷ����KN
U��å!�ox�Q(%v��:K2ѕ�������{ 	��\1���@�jB �X|;at��=1����Y��I���ՉGIbA�g�h� WQ�U�������G�\Us(��,$O�h�F!h՜�4�n��fYA#�\V1p�3���d!�HI@�BȠ��.P��;�b��M��H�tLL�����0B"�ļ*��i�r]'�]����-�Q̣^�c e�����"��)�����	)� �A�cC<�,ԣ�7��2���!?s�� ����z�F�v��P1��֤	���@¨��#�&V�!ֳ�a:����M�3i�Bsh5��d1s��$��,�耧<�^	��r'�ֲ��hd>2�L�)�j�dhXL��lf��0����"]�1ޫX�xT����#/8r��z�7h[��O��f�G ��@6O�&F[GEl��߶�:��&�2���j�Ė�Oc
Z��k����&!/�D5F��˵���GuQV���<����T�o�#�����	U_�T�?��Ϗ?��K/���A����/��/��n.0��ּۯ �
�qɺ�m�ࡏR����5�X!*i�ֵ���N�rE2�}쫽h��ׄ��n�;�|�~E�����۷�Q8�T�F��b�'}�w���%?��,�. �"/Q�m��+O��Z����w��i�P�_��r��M�qeC֬�k`NrO���PB�>a�{�v��0a|S5ul�D�k8_u�4����3      D   �  x����n�0E��W�$���ε�@m��0���@J��C��HN�n
��9�;C:�Q�{�{" SSU#�O��/�A,V��ڦ��;�{�l��_��K@J�Z���
M�h�VVd���;�
�@�'��vqbzh��!=7�������z�vW�F1+�$F~�'�/DF���	Y����\�U���l�B�Lf>e"�<��/���8�sZ%���~��}�u0tۮﻋ�u\D�x2;��Ud��^�PeY,�QgC�p�����1?�I��c"����Xr;-$��í��݁�qZ̈��3�F~ 
5�9lЗ����7UN,x4*��%2�x�H�����@�&���M%�,�)Q�d�
���,��+���f+V8�y��w\NLeY]��nps����r�~����y������QE�m+,�ȇś���Z*�pZH�s���K�ִ{�٧�����ܟ�m��!����Яk�����k�&�      F   d  x�u�Kj�0@��)t����ϻB)�4'�&��:��D=J/VYv"b���{3����k?�Kj�G�o�o 5AG�hv[EC���]#�y���Ռ�	�Y�0�B;�QR����M�ݰ%
B|��x�\I!�H������R��_��ukh�����՘����.#.$�[���E�>���
JQ�(�ײ�)I��y��.�m���s�{kb|��+J5\oExqK���	�U��$J�U��#:��n���Bn�k�ɵ��J7V�7�IB����	O��M봩D��R<C(���G��������S��~�k��z��x8Z���fXF��hL���_�A�c�vF)���)      J   �	  x��ZIr�8]ç���W�y�Β�QV[�B���6P&-��L��)���Ӌ>H]�?������M�C|� H	��֮������=��Ye��o��a���0cgԞ�O�qI���~B�	�͒�f�2�g�:E��C���y�T	V���;��X�"�$���iƱ9���BR ٢�X��ꉡ���:�2e�y�L���DW��!�o�n�6n�!!��E�ǹPy312�%B#��BL$"ױ����O5��х˾����)�dn�1�I�Tdv�5��s��+j����N�m�LZ�(�$�b�z��>�Zt���r��٣[.�uIbo4K݉)"e�)C��)F�`G����.�t��#�t����^�י<�u��Ӣ�b��Q
]k�a�V�S�٦FV�D�}^0��v����N7�`c�8����Ş�R'��������u7�D	B�%R ,@O��(�v������w��61���ĢoK�^E!꭫ �+�T���е�����!��|��u\ ���&�d�(��1{gP��5��M,B�!�/���t�V���x[��[|�)~�����o���]Zt�}ݏIvKIeY]���XUz{N��A���P`��	���A��&��α�@�[TzBIlxR2)@�#*G��:��=&G$�V\u�ΊC1dLi(J)cPKw�vp�G5��}31�%�,�6�i�M��b�3bB%����18)��$X���r��L2-����|�ߴ�[1�p���p�Fx�sOς�дm9OX��m5P�C����� Fꨭ��!1(�z�Fݗa�T�mN��A�N�� 
]~��jT[}l����K搆�\'��St6��2ᩁ���$5p5�V��	I���F��1��D@Y9m g��G�p��ʈCX�)���mcз�&]�����
�`6�h��vy#����$P����eIc�/�e�#� ���%�u	�KN9d�ÓM
�ڷ��k$.�7#1���i����(2��g���OKWl�4e�9. �V���.���oU��9�r[?��> �3m�!�^o3�R	��L����~P5�,���gڌ���{�̿���S|������?9~:ſ�M��9g�X=�4t���؄���p"'ՓN�w�Z]�	N�[ܱ��FK(�_x�I	��ݧ0aaE��:��R��Qg�����ڤ�2a�L���{���D`A��1d�{vPl���~.�b�6����х�,��[���$��f9��GE˛�6��m>��� cG���g����Q�gsڃ���s8���������~0g4����b�S���_J�3ZXRs聆��3s��r0�ot�^}�ԫ�b���i&�u����\]���H��#��mR+���e�4D��ж�0�(؜�U�%$�Y6��1!/�!f/>t[��#�߆@=*��n����(:E�fxQ2�K��x*ώ�w�Ű��������Ac�ܤ�E���y�@��`�pk^�?e���S��m5ݺ�.�?8߳�?">�d48���1�Y��=.�i]�: m4��	O#�s�
R� 1�v��&J�.NN�9�_=�[j�k�����U�Ku��~P�1�C��]����AR�T�!�F�mHb	��-��e;̂��^l?���d&�P���X����"d�H�咆�6ʪ'�F�忮;E��S����%G��yr@�����!SH����8�.��m1�=7�Q=�z�Ip�&���S��W��D����i[b�� ��+O�5Y2�G4너�"�����C��V�^�j������+�1o �V�����R�^��rpqSB�xi[`��48���J%L�c����_��F��b��Fg�k��JKF��b��c�>�H`;�4v���b+��I�Px����H����������f���<_��j�~�|���r��j�+lϩ�Tl�P�sǖ���B�H�sFkh}��[ZN�8�U���ȸ4�O��_�	k����q_��<]�x��s��NxDR���ή
JY�m��[B\�q���U07�Ӆ�%��q��#Ɇ ����11gT��4,ԡކ��<�1� �wh����޸�[L^
2_a��K��e1"S�2��e=f�!ח�����n�c�1\)�Bw�x�����]��K�XB�� �M���4gL�t��K��R�H�G;K�P~��t�n���F��î�Pg2H�DsQ��O���=/3�}���(��v������~��8���&B�i���(���k�l��AZ��$@�h����E�L ��T}����Fəq�;�g���$�(�#C�%d���v��f�U+�TLG�'1zV��i
�Η�[w��D߄F&��Ȫ��쀉ݢrl�R��`��ĉAG ;$Pp��:���{�=~�^�^�m�~�}c����l�: �Ķz��-�. w���#0�N��O���U�����0	HQj$�Kl���z���e�ߒ/^�Ӌ=      H      x������ � �     