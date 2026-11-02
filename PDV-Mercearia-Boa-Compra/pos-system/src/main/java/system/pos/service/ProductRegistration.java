package system.pos.service;
import system.pos.user.Operator;
import system.pos.model.Product;
import java.util.Scanner;
import  java.util.Map;
import java.util.HashMap;

/**
 * Parte do código responsável pelo CRUD do produto
 * Metodo: register
 *      Faz o registro de cada produto salvando em uma Lista
 * Metodo: consultation name/ID
 *      Faz a consulta do produto solicitado seja pelo nome ou pelo ID
 * Metodo: edit
 *      Edita o produto selecionado.
 * Metodo: delet
 *      Apaga o produto selecionado.
 * */

public class ProductRegistration {
    private Map<Long, Product> products = new HashMap<>();
    Operator operator;
    private Scanner input;

    public ProductRegistration(Operator operador){
        this.operator = operador;
        this.input = new Scanner(System.in);
    }

    public void register(int qtd){
        System.out.println("=================");
        for(int i=0; i<qtd; i++){
            System.out.println("-----Produto " + (i+1) + "-----");

            Product product = new Product();

            System.out.print("ID: ");
            long chave = input.nextLong();
            if(products.containsKey(chave)){
                System.err.println("ID já cadastrado");
                i--;
                continue;
            }
            product.setId(chave);


            System.out.print("Código de Barras: ");
            String barCode = input.next();
            if(!barCode.matches("\\d{13}")){
                System.err.println("\n Código de barras incorreto.");
                i--;
                continue;
            }
            product.setBarcode(barCode);

            System.out.print("Nome do produto: ");
            product.setName(input.next());

            System.out.print("Preço: ");
            double preco = input.nextDouble();
            if(preco <=0){
                System.out.println("O valor tem que ser maior que zero");
                i--;
                continue;
            }

            String precoConvert = String.valueOf(preco);
            product.setPrice(precoConvert);

            System.out.print("Estoque: ");
            long stok = input.nextLong();

            if(stok <=0){
                System.out.println("O valor do estoque tem que ser mairo que zero");
                i--;
                continue;
            }
            String stokConvert = Long.toString(stok);
            product.setStok(stokConvert);


            System.out.print("Peso: ");
            double peso = input.nextDouble();
            if(peso <= 0){
                System.out.println("Peso incorreto");
                i--;
                continue;
            }
            String pesoConvert = String.valueOf(peso);
            product.setWeight(pesoConvert);



            System.out.print("Produto a venda: ");
            String ativo = input.next().toLowerCase();
            product.isAvalaible(ativo.equalsIgnoreCase("s") || ativo.equalsIgnoreCase("sim"));

            products.put(chave,product);
        }
        System.out.println("=================");
        System.out.println("Produto cadastrado com êxito");

    }

    public void consulation(){
        System.out.print("Pesquise por ID ou Nome o produto solicitado:");
        String busca = input.next();

        Product encontrado = null;

        if(busca.matches("\\d+")){
            encontrado = products.get(Long.parseLong(busca));
        }

        if(encontrado==null){
            for(Product p: products.values()){
                encontrado = p;
                break;
            }
        }

        if(encontrado !=null){
            System.out.println("Produto localizado: ");
            System.out.println(encontrado);

        }else{
            System.err.println("Produto não cadastrado");
        }
    }

    public void edit(){
        System.out.println("Informe o ID para editar");
        String texto = input.nextLine().trim();

        if(!texto.matches("\\d+")){
            System.err.println("ID inválido");
            return;
        }

        Product product = products.get(Long.parseLong(texto));
        if(product == null){
            System.err.println("Produto não cadastrado");
            return;
        }
        System.out.println("=================");
        System.out.println("Produto atual");
        System.out.println(product);
        System.out.println("=================");

        System.out.println("Novo nome (pressione enter para manter)");
        String nome = input.nextLine().trim().toUpperCase();
        if(!nome.isEmpty()){
            product.setName(nome);
        }

        System.out.println("Novo preço (pressione enter para manter)");
        String preco = input.nextLine().trim().replace(",", ".");
        if(!preco.isEmpty()){
            try{
                double valor = Double.parseDouble(preco);
                if(valor > 0){
                    product.setPrice(String.valueOf(valor));
                }else{
                    System.err.println("Preço deve ser maior que zero. Mantido o anterior");
                }
            }catch (NumberFormatException e){
                System.err.println("Preço inválido. mantido o anterior");
            }
        }

        System.out.println("produto Atualizado");

        System.out.println("=================");
        System.out.println("Produto atual");
        System.out.println(product);
        System.out.println("=================");

    }

    public void delete() {
        System.out.print("ID do produto a apagar: ");
        String texto = input.nextLine().trim();

        if (!texto.matches("\\d+")) {
            System.err.println("ID inválido.");
            return;
        }

        long id = Long.parseLong(texto);
        Product product = products.get(id);

        if (product == null) {
            System.err.println("Produto não cadastrado.");
            return;
        }

        System.out.println("Produto encontrado:");
        System.out.println(product);

        System.out.print("Confirmar exclusão (s/n)? ");
        String resp = input.nextLine().trim();

        if (resp.equalsIgnoreCase("s") || resp.equalsIgnoreCase("sim")) {
            products.remove(id);
            System.out.println("Produto apagado com sucesso.");
        } else {
            System.out.println("Exclusão cancelada.");
        }
    }
}
