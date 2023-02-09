Feature: Login
  Como usuario quiero ingresar al pagina con mis credenciales
  Scenario: Realizar login exitoso
    Given El usuario se encuentra en el inicio de la pagina
    When El usuario introduce sus credenciales correctamente
    Then El usuario visualiza la pantalla de productos de la pagina

  Scenario: Realizar login fallido
    Given El usuario se encuentra en el inicio de la pagina
    When El usuario introduce sus credenciales incorrectamente
    Then El usuario visualiza un mensaje de login fallido