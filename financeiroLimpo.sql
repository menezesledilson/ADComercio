PGDMP                          |         
   financeiro    13.13    13.13 S    #           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            $           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            %           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            &           1262    24600 
   financeiro    DATABASE     j   CREATE DATABASE financeiro WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE financeiro;
                postgres    false            �            1259    73911    acesso    TABLE     �   CREATE TABLE public.acesso (
    id integer NOT NULL,
    nome character varying(60),
    login character varying(10),
    senha character varying(8),
    permissao character varying(18)
);
    DROP TABLE public.acesso;
       public         heap    postgres    false            �            1259    73909    acesso_id_seq    SEQUENCE     �   CREATE SEQUENCE public.acesso_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.acesso_id_seq;
       public          postgres    false    215            '           0    0    acesso_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.acesso_id_seq OWNED BY public.acesso.id;
          public          postgres    false    214            �            1259    65717    bobina    TABLE     �   CREATE TABLE public.bobina (
    id integer NOT NULL,
    nomebobina character varying(60) NOT NULL,
    valorbobina numeric(10,2) NOT NULL
);
    DROP TABLE public.bobina;
       public         heap    postgres    false            �            1259    65720    bobina_id_seq    SEQUENCE     �   CREATE SEQUENCE public.bobina_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.bobina_id_seq;
       public          postgres    false    200            (           0    0    bobina_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.bobina_id_seq OWNED BY public.bobina.id;
          public          postgres    false    201            �            1259    65722    boletoempresa    TABLE     P  CREATE TABLE public.boletoempresa (
    id integer NOT NULL,
    nomeboletoreceber character varying(60) NOT NULL,
    databoletoreceber date NOT NULL,
    valorboletoreceber numeric(10,2) NOT NULL,
    nomeboletoapagar character varying(60) NOT NULL,
    databoletoapagar date NOT NULL,
    valorboletoapagar numeric(10,2) NOT NULL
);
 !   DROP TABLE public.boletoempresa;
       public         heap    postgres    false            �            1259    65725    boletoempresa_id_seq    SEQUENCE     �   CREATE SEQUENCE public.boletoempresa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.boletoempresa_id_seq;
       public          postgres    false    202            )           0    0    boletoempresa_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.boletoempresa_id_seq OWNED BY public.boletoempresa.id;
          public          postgres    false    203            �            1259    65727    caixa    TABLE     <  CREATE TABLE public.caixa (
    id integer NOT NULL,
    datahora timestamp without time zone DEFAULT date_trunc('MINUTE'::text, CURRENT_TIMESTAMP),
    descricao character varying(100),
    entrada double precision,
    saida double precision,
    saldoanterior double precision,
    saldoatual double precision
);
    DROP TABLE public.caixa;
       public         heap    postgres    false            �            1259    65735    caixa_id_seq    SEQUENCE     �   CREATE SEQUENCE public.caixa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.caixa_id_seq;
       public          postgres    false    204            *           0    0    caixa_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.caixa_id_seq OWNED BY public.caixa.id;
          public          postgres    false    205            �            1259    65739    emissornotacliente    TABLE     �  CREATE TABLE public.emissornotacliente (
    id integer NOT NULL,
    idbobina integer,
    datanotaservico timestamp without time zone DEFAULT date_trunc('minute'::text, CURRENT_TIMESTAMP),
    quantproduto integer,
    valorunitario double precision,
    valorpeso double precision,
    cargainicial double precision,
    nomeproduto character varying(60),
    clienteempresa character varying(60)
);
 &   DROP TABLE public.emissornotacliente;
       public         heap    postgres    false            �            1259    65743    calculonf_id_seq    SEQUENCE     �   CREATE SEQUENCE public.calculonf_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.calculonf_id_seq;
       public          postgres    false    206            +           0    0    calculonf_id_seq    SEQUENCE OWNED BY     N   ALTER SEQUENCE public.calculonf_id_seq OWNED BY public.emissornotacliente.id;
          public          postgres    false    207            �            1259    90313    controlevendedor    TABLE     �   CREATE TABLE public.controlevendedor (
    id integer NOT NULL,
    nomevenda character varying(60),
    valorvenda double precision,
    datahoravenda timestamp without time zone DEFAULT date_trunc('minute'::text, CURRENT_TIMESTAMP)
);
 $   DROP TABLE public.controlevendedor;
       public         heap    postgres    false            �            1259    90311    controlevendedor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.controlevendedor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.controlevendedor_id_seq;
       public          postgres    false    221            ,           0    0    controlevendedor_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.controlevendedor_id_seq OWNED BY public.controlevendedor.id;
          public          postgres    false    220            �            1259    65750    emissornotaservico    TABLE     �  CREATE TABLE public.emissornotaservico (
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
       public         heap    postgres    false            �            1259    65754    emissornotaservico_id_seq    SEQUENCE     �   CREATE SEQUENCE public.emissornotaservico_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.emissornotaservico_id_seq;
       public          postgres    false    208            -           0    0    emissornotaservico_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.emissornotaservico_id_seq OWNED BY public.emissornotaservico.id;
          public          postgres    false    209            �            1259    90295    notaservico    TABLE       CREATE TABLE public.notaservico (
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
    comissaoproduto double precision,
    apagarproduto double precision
);
    DROP TABLE public.notaservico;
       public         heap    postgres    false            �            1259    90293    notaservico_id_seq    SEQUENCE     �   CREATE SEQUENCE public.notaservico_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.notaservico_id_seq;
       public          postgres    false    217            .           0    0    notaservico_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.notaservico_id_seq OWNED BY public.notaservico.id;
          public          postgres    false    216            �            1259    90304    pagamentofabrica    TABLE     �   CREATE TABLE public.pagamentofabrica (
    id integer NOT NULL,
    nomepagamento character varying(60),
    valorpagamento double precision,
    datahorapagamento timestamp without time zone DEFAULT date_trunc('minute'::text, CURRENT_TIMESTAMP)
);
 $   DROP TABLE public.pagamentofabrica;
       public         heap    postgres    false            �            1259    90302    pagamentofabrica_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pagamentofabrica_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.pagamentofabrica_id_seq;
       public          postgres    false    219            /           0    0    pagamentofabrica_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.pagamentofabrica_id_seq OWNED BY public.pagamentofabrica.id;
          public          postgres    false    218            �            1259    65756    pedidocomprabobina    TABLE     �  CREATE TABLE public.pedidocomprabobina (
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
       public         heap    postgres    false            �            1259    65760    pedido_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pedido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.pedido_id_seq;
       public          postgres    false    210            0           0    0    pedido_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.pedido_id_seq OWNED BY public.pedidocomprabobina.id;
          public          postgres    false    211            �            1259    65762    pedidobobina    TABLE     e  CREATE TABLE public.pedidobobina (
    id integer NOT NULL,
    nomecliente character varying(60),
    valorpedido numeric(10,2),
    quantidadebobina integer,
    datapedido date,
    dataentrega date,
    numerochequea integer,
    numerochequeb integer,
    numerochequec integer,
    observacao character varying(80),
    pagpedido character varying
);
     DROP TABLE public.pedidobobina;
       public         heap    postgres    false            �            1259    65765    pedidobobina_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pedidobobina_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.pedidobobina_id_seq;
       public          postgres    false    212            1           0    0    pedidobobina_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.pedidobobina_id_seq OWNED BY public.pedidobobina.id;
          public          postgres    false    213            j           2604    82110 	   acesso id    DEFAULT     f   ALTER TABLE ONLY public.acesso ALTER COLUMN id SET DEFAULT nextval('public.acesso_id_seq'::regclass);
 8   ALTER TABLE public.acesso ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215            _           2604    82111 	   bobina id    DEFAULT     f   ALTER TABLE ONLY public.bobina ALTER COLUMN id SET DEFAULT nextval('public.bobina_id_seq'::regclass);
 8   ALTER TABLE public.bobina ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    201    200            `           2604    82112    boletoempresa id    DEFAULT     t   ALTER TABLE ONLY public.boletoempresa ALTER COLUMN id SET DEFAULT nextval('public.boletoempresa_id_seq'::regclass);
 ?   ALTER TABLE public.boletoempresa ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202            a           2604    82113    caixa id    DEFAULT     d   ALTER TABLE ONLY public.caixa ALTER COLUMN id SET DEFAULT nextval('public.caixa_id_seq'::regclass);
 7   ALTER TABLE public.caixa ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204            o           2604    90316    controlevendedor id    DEFAULT     z   ALTER TABLE ONLY public.controlevendedor ALTER COLUMN id SET DEFAULT nextval('public.controlevendedor_id_seq'::regclass);
 B   ALTER TABLE public.controlevendedor ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    221    220    221            c           2604    82115    emissornotacliente id    DEFAULT     u   ALTER TABLE ONLY public.emissornotacliente ALTER COLUMN id SET DEFAULT nextval('public.calculonf_id_seq'::regclass);
 D   ALTER TABLE public.emissornotacliente ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    207    206            e           2604    82116    emissornotaservico id    DEFAULT     ~   ALTER TABLE ONLY public.emissornotaservico ALTER COLUMN id SET DEFAULT nextval('public.emissornotaservico_id_seq'::regclass);
 D   ALTER TABLE public.emissornotaservico ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    208            l           2604    90298    notaservico id    DEFAULT     p   ALTER TABLE ONLY public.notaservico ALTER COLUMN id SET DEFAULT nextval('public.notaservico_id_seq'::regclass);
 =   ALTER TABLE public.notaservico ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    217    217            m           2604    90307    pagamentofabrica id    DEFAULT     z   ALTER TABLE ONLY public.pagamentofabrica ALTER COLUMN id SET DEFAULT nextval('public.pagamentofabrica_id_seq'::regclass);
 B   ALTER TABLE public.pagamentofabrica ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    219    218    219            i           2604    82117    pedidobobina id    DEFAULT     r   ALTER TABLE ONLY public.pedidobobina ALTER COLUMN id SET DEFAULT nextval('public.pedidobobina_id_seq'::regclass);
 >   ALTER TABLE public.pedidobobina ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    213    212            g           2604    82118    pedidocomprabobina id    DEFAULT     r   ALTER TABLE ONLY public.pedidocomprabobina ALTER COLUMN id SET DEFAULT nextval('public.pedido_id_seq'::regclass);
 D   ALTER TABLE public.pedidocomprabobina ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    211    210                      0    73911    acesso 
   TABLE DATA           C   COPY public.acesso (id, nome, login, senha, permissao) FROM stdin;
    public          postgres    false    215   �e                 0    65717    bobina 
   TABLE DATA           =   COPY public.bobina (id, nomebobina, valorbobina) FROM stdin;
    public          postgres    false    200   f                 0    65722    boletoempresa 
   TABLE DATA           �   COPY public.boletoempresa (id, nomeboletoreceber, databoletoreceber, valorboletoreceber, nomeboletoapagar, databoletoapagar, valorboletoapagar) FROM stdin;
    public          postgres    false    202   �f                 0    65727    caixa 
   TABLE DATA           c   COPY public.caixa (id, datahora, descricao, entrada, saida, saldoanterior, saldoatual) FROM stdin;
    public          postgres    false    204   �f                  0    90313    controlevendedor 
   TABLE DATA           T   COPY public.controlevendedor (id, nomevenda, valorvenda, datahoravenda) FROM stdin;
    public          postgres    false    221   �f                 0    65739    emissornotacliente 
   TABLE DATA           �   COPY public.emissornotacliente (id, idbobina, datanotaservico, quantproduto, valorunitario, valorpeso, cargainicial, nomeproduto, clienteempresa) FROM stdin;
    public          postgres    false    206   g                 0    65750    emissornotaservico 
   TABLE DATA           �   COPY public.emissornotaservico (id, datanotaservico, clientefornecedor, cargainicial, frete, totalfretecarga, imposto, totalimpostocarga, totalcomissao, comissao, totalfinalcarga) FROM stdin;
    public          postgres    false    208   /g                 0    90295    notaservico 
   TABLE DATA           �   COPY public.notaservico (id, datahora, prestador, tomador, descricao, quantidade, precoproduto, pesoproduto, totalproduto, freteproduto, impostoproduto, comissaoproduto, apagarproduto) FROM stdin;
    public          postgres    false    217   Lg                 0    90304    pagamentofabrica 
   TABLE DATA           `   COPY public.pagamentofabrica (id, nomepagamento, valorpagamento, datahorapagamento) FROM stdin;
    public          postgres    false    219   ig                 0    65762    pedidobobina 
   TABLE DATA           �   COPY public.pedidobobina (id, nomecliente, valorpedido, quantidadebobina, datapedido, dataentrega, numerochequea, numerochequeb, numerochequec, observacao, pagpedido) FROM stdin;
    public          postgres    false    212   �g                 0    65756    pedidocomprabobina 
   TABLE DATA           �   COPY public.pedidocomprabobina (id, idbobina, descricao, datapedido, quantidade, pesopapel, valorunitario, totalpedido, nomeempresa, acumulo) FROM stdin;
    public          postgres    false    210   �g       2           0    0    acesso_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.acesso_id_seq', 12, true);
          public          postgres    false    214            3           0    0    bobina_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.bobina_id_seq', 50, true);
          public          postgres    false    201            4           0    0    boletoempresa_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.boletoempresa_id_seq', 1, false);
          public          postgres    false    203            5           0    0    caixa_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.caixa_id_seq', 1, false);
          public          postgres    false    205            6           0    0    calculonf_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.calculonf_id_seq', 1, false);
          public          postgres    false    207            7           0    0    controlevendedor_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.controlevendedor_id_seq', 1, false);
          public          postgres    false    220            8           0    0    emissornotaservico_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.emissornotaservico_id_seq', 1, false);
          public          postgres    false    209            9           0    0    notaservico_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.notaservico_id_seq', 1, false);
          public          postgres    false    216            :           0    0    pagamentofabrica_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.pagamentofabrica_id_seq', 1, false);
          public          postgres    false    218            ;           0    0    pedido_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.pedido_id_seq', 1, false);
          public          postgres    false    211            <           0    0    pedidobobina_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.pedidobobina_id_seq', 1, false);
          public          postgres    false    213            �           2606    73916    acesso acesso_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.acesso
    ADD CONSTRAINT acesso_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.acesso DROP CONSTRAINT acesso_pkey;
       public            postgres    false    215            r           2606    65777    bobina bobina_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.bobina
    ADD CONSTRAINT bobina_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.bobina DROP CONSTRAINT bobina_pkey;
       public            postgres    false    200            t           2606    65779     boletoempresa boletoempresa_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.boletoempresa
    ADD CONSTRAINT boletoempresa_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.boletoempresa DROP CONSTRAINT boletoempresa_pkey;
       public            postgres    false    202            v           2606    65781    caixa caixa_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.caixa
    ADD CONSTRAINT caixa_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.caixa DROP CONSTRAINT caixa_pkey;
       public            postgres    false    204            x           2606    65785 !   emissornotacliente calculonf_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.emissornotacliente
    ADD CONSTRAINT calculonf_pkey PRIMARY KEY (id);
 K   ALTER TABLE ONLY public.emissornotacliente DROP CONSTRAINT calculonf_pkey;
       public            postgres    false    206            �           2606    90319 &   controlevendedor controlevendedor_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.controlevendedor
    ADD CONSTRAINT controlevendedor_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.controlevendedor DROP CONSTRAINT controlevendedor_pkey;
       public            postgres    false    221            z           2606    65789 *   emissornotaservico emissornotaservico_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.emissornotaservico
    ADD CONSTRAINT emissornotaservico_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.emissornotaservico DROP CONSTRAINT emissornotaservico_pkey;
       public            postgres    false    208            �           2606    90301    notaservico notaservico_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.notaservico
    ADD CONSTRAINT notaservico_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.notaservico DROP CONSTRAINT notaservico_pkey;
       public            postgres    false    217            �           2606    90310 &   pagamentofabrica pagamentofabrica_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.pagamentofabrica
    ADD CONSTRAINT pagamentofabrica_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.pagamentofabrica DROP CONSTRAINT pagamentofabrica_pkey;
       public            postgres    false    219            |           2606    65791    pedidocomprabobina pedido_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.pedidocomprabobina
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.pedidocomprabobina DROP CONSTRAINT pedido_pkey;
       public            postgres    false    210            ~           2606    65793    pedidobobina pedidobobina_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.pedidobobina
    ADD CONSTRAINT pedidobobina_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.pedidobobina DROP CONSTRAINT pedidobobina_pkey;
       public            postgres    false    212            �           2606    65794 *   emissornotacliente calculonf_idbobina_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.emissornotacliente
    ADD CONSTRAINT calculonf_idbobina_fkey FOREIGN KEY (idbobina) REFERENCES public.bobina(id);
 T   ALTER TABLE ONLY public.emissornotacliente DROP CONSTRAINT calculonf_idbobina_fkey;
       public          postgres    false    2930    206    200            �           2606    65809 '   pedidocomprabobina pedido_idbobina_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.pedidocomprabobina
    ADD CONSTRAINT pedido_idbobina_fkey FOREIGN KEY (idbobina) REFERENCES public.bobina(id) ON UPDATE CASCADE ON DELETE CASCADE;
 Q   ALTER TABLE ONLY public.pedidocomprabobina DROP CONSTRAINT pedido_idbobina_fkey;
       public          postgres    false    210    2930    200               S   x�m�1
�0F���a��K���%���@����U���*6甀i��M��}��Y��L/vI����y����V��}*�ܢ"�         �   x�m���0E�ׯx_@^[
�.��եڪ$@�	�o!Q�Ϲ7�J8�k�kt�y��h�IJX!�	K��]���i&�."������SZ�����kd���D7*����;k�P�$N�St���O�EG�/�����Ը���goGoA�Y�$��7�Ty            x������ � �            x������ � �             x������ � �            x������ � �            x������ � �            x������ � �            x������ � �            x������ � �            x������ � �     