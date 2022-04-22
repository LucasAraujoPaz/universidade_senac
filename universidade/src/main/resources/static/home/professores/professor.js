/**
 * @typedef {{
 * id: number,
 * cpf: number,
 * nome: string,
 * dataDeNascimento: Date,
 * email: string,
 * telefone: number,
 * salario: number
 * }} IProfessor
 */

/**
 * @implements {IProfessor} 
 * @implements {IEntidadeComId} 
 */
class Professor {

    /** @param {IProfessor} professor */
    constructor({id, cpf, nome,dataDeNascimento, email, telefone, salario}) {
            ;this.id = sanitizarId(id);
            this.cpf = cpf;
            this.nome = nome;
            this.dataDeNascimento = sanitizarData(dataDeNascimento);
            this.email = email;
            this.telefone = telefone;
            this.salario = salario;
    }
}

/** @type {ICRUD<Professor>} */
Professor.CRUD = {

    URL: Internet.URLS.URL_PROFESSORES,

    async listar() {
        /** @type {IProfessor[]} */
        const professores = await Internet.getJson(this.URL)
        return professores.map(professor => new Professor(professor));
    },
    async obter(id) {
        /** @type {IProfessor} */
        const professor = await Internet.getJson(this.URL + "/" + id);
        return new Professor(professor);
    },
    async criar(professor) {
        return await Internet.post(this.URL, professor);
    },
    async editar(professor) {
        return await Internet.put(this.URL, professor);
    },
    async deletar(id) {
        await Internet.delete(this.URL + "/" + id);
    }
}

/** @type {IFormulario<Professor>} */
Professor.Formulario = {

    nomeDoLink: "linkProfessores",
    nomeDoFormulario: "professor",

    async preencher(professor) {
    
        await renderizarCorpo("professores/professor.html");

        Formulario.preencher(Professor, professor);

        const dataDeNascimento =  /** @type {HTMLInputElement} */
            (document.forms
            .namedItem(this.nomeDoFormulario)?.elements
            .namedItem("dataDeNascimento"));
        
        if (! (dataDeNascimento && professor) ) 
            return;

        dataDeNascimento.value = 
            professor.dataDeNascimento.toLocaleDateString("en-CA");
    },

    obter() {
            
        const form = document.forms.namedItem(this.nomeDoFormulario);
        if (!form)
            throw new Error("Erro no formulário.");
        const fd = new FormData(form);

        const professor = new Professor({
            id: sanitizarId(fd.get("id")),
            cpf: Number(fd.get("cpf")),
            nome: String(fd.get("nome")),
            dataDeNascimento: new Date(String(fd.get("dataDeNascimento"))),
            email: String(fd.get("email")),
            telefone: Number(fd.get("telefone")),
            salario: Number(fd.get("salario"))
        });
        
        return professor;
    }
}