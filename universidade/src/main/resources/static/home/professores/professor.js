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

    /**
     * @param {number} id
     * @param {number} cpf
     * @param {string} nome
     * @param {Date} dataDeNascimento
     * @param {string} email
     * @param {number} telefone
     * @param {number} salario
     */
    constructor(id, cpf, nome,dataDeNascimento, email, telefone, salario) {
            this.id = id;
            this.cpf = cpf;
            this.nome = nome;
            this.dataDeNascimento = dataDeNascimento;
            this.email = email;
            this.telefone = telefone;
            this.salario = salario;
    }
}

/**@type {ICRUD<Professor>} */
Professor.CRUD = {

    URL: Internet.URLS.URL_PROFESSORES,

    async listar() {
        /** @type {Professor[]} */
        const professores = await Internet.getJson(this.URL)
        professores.forEach(professor => professor.dataDeNascimento = sanitizarData(professor.dataDeNascimento));

        return professores;
    },
    async obter(id) {
        /** @type {Professor} */
        const professor = await Internet.getJson(this.URL + "/" + id);
        professor.dataDeNascimento = sanitizarData(professor.dataDeNascimento);

        return professor;
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

        const elements = document.forms.namedItem(this.nomeDoFormulario)?.elements;
        if (! (elements && professor) ) 
            return;
        
        // @ts-expect-error
        elements.dataDeNascimento.value = 
            professor.dataDeNascimento.toLocaleDateString("en-CA");
    },

    obter() {
            
        const elements = document.forms.namedItem(this.nomeDoFormulario)?.elements;
        if (!elements)
            throw new Error("Erro no formulário.");

        const professor = new Professor(//@ts-expect-error
            elements.id.value.length == 0 ? -1 : elements.id.value, //@ts-expect-error
            elements.cpf.value, //@ts-expect-error
            elements.nome.value, //@ts-expect-error
            sanitizarData(elements.dataDeNascimento.value), //@ts-expect-error
            elements.email.value, //@ts-expect-error
            elements.telefone.value, //@ts-expect-error
            elements.salario.value);
        
        return professor;
    }
}