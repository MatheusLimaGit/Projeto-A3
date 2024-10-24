@Service
public class EstoqueConsumer {

    @Autowired
    private EstoqueService estoqueService;

    @KafkaListener(topics = "estoque_atualizacao", groupId = "grupo_exemplo")
    public void consumir(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);
        
        // Supondo que a mensagem seja um JSON com campos "produtoId" e "quantidade"
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            EstoqueAtualizacao atualizacao = objectMapper.readValue(mensagem, EstoqueAtualizacao.class);
            
            // Atualiza o estoque com base na mensagem
            estoqueService.atualizarEstoque(atualizacao.getProdutoId(), atualizacao.getQuantidade());
        } catch (JsonProcessingException e) {
            System.err.println("Erro ao processar a mensagem: " + e.getMessage());
        }
    }
}
public class EstoqueAtualizacao {
    private String produtoId;
    private int quantidade;

    // Getters e setters
    public String getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}