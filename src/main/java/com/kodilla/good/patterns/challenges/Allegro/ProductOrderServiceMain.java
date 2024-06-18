package com.kodilla.good.patterns.challenges.Allegro;

public class ProductOrderServiceMain {
    private InformationService informationService;
    private ProductOrderService productOrderService;
    private OrderRepository orderRepository;

    public ProductOrderServiceMain(final InformationService informationService,
                                   final ProductOrderService productOrderService,
                                   final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.productOrderService = productOrderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = productOrderService.order(orderRequest.getUser(), orderRequest.getProduct());
        if (isOrdered) {
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }

    public static void main(String[] args) {
        User user = new User("John Doe", "john.doe@example.com");
        Product product = new Product("The Witcher 3: Wild Hunt");

        InformationService informationService = new EmailInformationService();
        ProductOrderService productOrderService = new GameOrderService();
        OrderRepository orderRepository = new InMemoryOrderRepository();

        ProductOrderServiceMain orderService = new ProductOrderServiceMain(informationService, productOrderService, orderRepository);

        OrderRequest orderRequest = new OrderRequest(user, product);
        OrderDto orderDto = orderService.process(orderRequest);

        System.out.println("Order for " + orderDto.getUser().getName() + " was " + (orderDto.isOrdered() ? "successful" : "unsuccessful"));
    }
}
