// https://docs.cypress.io/api/introduction/api.html

describe('Login', () => {
  it('Login test', () => {

    // Falseamos las respuestas del servidor
    cy.server()
    cy.route('POST', '**/auth/login', {
      "id_token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJFRElUX0NVU1RPTUVSLEVESVRfVVNFUixST0xFX0FETUlOLFJPTEVfVVNFUixWSUVXX0NVU1RPTUVSIiwiZXhwIjoxNjIyNjIxODU3fQ.lHwb626CESyHx91hRTKi6yQvRVbZKbGfkp2IiE-LU5ESRanhB2o_rw-Ksz1AmtraH-DFMOZHIGzc_QTwriFbIQ"
    })
    cy.route('GET', '**/auth/user', {
          "id": 1,
          "username": "user",
          "password": "password",
          "firstname": "user",
          "lastname": "user",
          "email": "user@email.com",
          "activated": true,
          "authorities": [
            {
              "name": "ROLE_USER"
            },
            {
              "name": "VIEW_CUSTOMER"
            }
          ]
    })
    cy.route('GET', '**/api/customers', [
      {
          "id": 1,
          "cif": "A123456789",
          "name": "La Empresa S.L.",
          "address": "Calle La traviata Nº 11 P1º",
          "city": "Alicante",
          "postalCode": "03678",
          "country": "ES",
          "email": "email@email.com",
          "phone": "+34 987 654 321",
          "people": "Empleado 1, empleado 2...",
          "observations": "Añadir observaciones...",
          "detail": null
      }
  ])

    // Comprobamos que al ir al home nos redirige al login
    cy.visit('http://localhost:8081/')
    cy.contains('body', 'Inicio sesión')

    // Insertamos los credenciales del usuario
    cy.get('#input-11').type('user')
    cy.get('#input-14').type('user')
    cy.get('.mt-4').click()

    // Comprobamos que se haya autenticado correctamente
    cy.contains('body', 'Clientes')
  })
})
