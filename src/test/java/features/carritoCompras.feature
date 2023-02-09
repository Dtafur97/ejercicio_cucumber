Feature: Carrito de compras
  Como usuario quiero agregar productos a mi carrito de compras
  Scenario: Añadir un producto al carrito de compras
    Given El usuario visualiza la pagina principal
    When El usuario agrega un producto al carrito de compras
    Then El usuario visualiza que se agrego un producto al carro de compras

  Scenario: Quitar un producto del carrito de compras
    Given El usuario visualiza la pagina principal
    When El usuario remueve el producto de su carrito de compras
    Then El usuario visualiza que no tiene productos agregados
