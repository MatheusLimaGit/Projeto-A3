@Service
public class PedidoProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "estoque_atualizacao";

    public void enviarMensagem(String mensagem) {
        kafkaTemplate.send(TOPIC, mensagem);
    }
}
