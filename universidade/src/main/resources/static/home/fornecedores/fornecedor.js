/**
 * @typedef {{
 * id: number,
 * cnpj: number,
 * nome: string,
 * email: string,
 * telefone: number,
 * descricao: string
 * }} IFornecedor
 */

/**
 * @implements {IFornecedor} 
 * @implements {IEntidadeComId} 
*/
class Fornecedor {

    /**
     * @param {number} id
     * @param {number} cnpj
     * @param {string} nome
     * @param {string} email
     * @param {number} telefone
     * @param {string} descricao
     */
    constructor(id, cnpj, nome, email, telefone, descricao) {
            this.id = id;
            this.cnpj = cnpj;
            this.nome = nome;
            this.email = email;
            this.telefone = telefone;
            this.descricao = descricao;
    }
}

/** @type {ICRUD<Fornecedor>} */
Fornecedor.CRUD = {

    URL: Internet.URLS.URL_FORNECEDORES,

    async listar() {
        /** @type {Fornecedor[]} */
        const fornecedores = await Internet.getJson(this.URL)

        return fornecedores;
    },
    async obter(id) {
        /** @type {Fornecedor} */
        const fornecedor = await Internet.getJson(this.URL + "/" + id);

        return fornecedor;
    },
    async criar(fornecedor) {
        return await Internet.post(this.URL, fornecedor);
    },
    async editar(fornecedor) {
        return await Internet.put(this.URL, fornecedor);
    },
    async deletar(id) {
        await Internet.delete(this.URL + "/" + id);
    }
}

/** @type {IFormulario<Fornecedor>} */
Fornecedor.Formulario = {

    nomeDoLink: "linkFornecedores",
    nomeDoFormulario: "fornecedor",

    async preencher(fornecedor) {
    
        await renderizarCorpo("fornecedores/fornecedor.html");

        Formulario.preencher(Fornecedor, fornecedor);
    },

    obter() {
            
        const elements = document.forms.namedItem(this.nomeDoFormulario)?.elements;
        if (!elements)
            throw new Error("Erro no formulário.");

        const fornecedor = new Fornecedor( // @ts-expect-error
            elements.id.value.length == 0 ? -1 : elements.id.value, // @ts-expect-error
            elements.cnpj.value, // @ts-expect-error
            elements.nome.value, // @ts-expect-error
            elements.email.value, // @ts-expect-error
            elements.telefone.value, // @ts-expect-error
            elements.descricao.value);
        
        return fornecedor;
    }
}