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
     * @param {IFornecedor} fornecedor
     */
    constructor({id, cnpj, nome, email, telefone, descricao}) {
            this.id = sanitizarId(id);
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
        /** @type {IFornecedor[]} */
        const fornecedores = await Internet.getJson(this.URL)
        return fornecedores.map(fornecedor => new Fornecedor(fornecedor));
    },
    async obter(id) {
        /** @type {IFornecedor} */
        const fornecedor = await Internet.getJson(this.URL + "/" + id);
        return new Fornecedor(fornecedor);
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
            
        const form = document.forms.namedItem(this.nomeDoFormulario);
        if (!form)
            throw new Error("Erro no formulário.");
        const fd = new FormData(form);

        const fornecedor = new Fornecedor({
            id: sanitizarId(fd.get("id")),
            cnpj: Number(fd.get("cpf")),
            nome: String(fd.get("nome")),
            email: String(fd.get("email")),
            telefone: Number(fd.get("telefone")),
            descricao: String(fd.get("descricao"))
        });
        
        return fornecedor;
    }
}