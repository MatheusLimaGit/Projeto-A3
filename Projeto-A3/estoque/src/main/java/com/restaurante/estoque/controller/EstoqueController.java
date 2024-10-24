@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService service;

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Estoque> atualizarEstoque(@PathVariable Long id, @RequestParam int quantidade) {
        Estoque estoqueAtualizado = service.atualizarEstoque(id, quantidade);
        return estoqueAtualizado != null ? ResponseEntity.ok(estoqueAtualizado) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Estoque> buscarTodosItens() {
        return service.buscarTodosItens();
    }
}
