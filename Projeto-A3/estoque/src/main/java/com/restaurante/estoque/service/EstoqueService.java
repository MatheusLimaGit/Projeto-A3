@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository repository;

    public Estoque atualizarEstoque(Long id, int quantidade) {
        Estoque itemEstoque = repository.findById(id).orElse(null);
        if (itemEstoque != null) {
            itemEstoque.setQuantidade(itemEstoque.getQuantidade() - quantidade);
            return repository.save(itemEstoque);
        }
        return null;
    }

    public List<Estoque> buscarTodosItens() {
        return repository.findAll();
    }
}
