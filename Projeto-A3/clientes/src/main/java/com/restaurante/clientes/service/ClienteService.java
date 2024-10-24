@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> buscarTodosClientes() {
        return repository.findAll();
    }

    public Cliente buscarClientePorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Cliente criarCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente atualizarCliente(Long id, Cliente cliente) {
        Cliente clienteExistente = repository.findById(id).orElse(null);
        if (clienteExistente != null) {
            clienteExistente.setNome(cliente.getNome());
            clienteExistente.setEndereco(cliente.getEndereco());
            return repository.save(clienteExistente);
        }
        return null;
    }

    public void deletarCliente(Long id) {
        repository.deleteById(id);
    }
}
