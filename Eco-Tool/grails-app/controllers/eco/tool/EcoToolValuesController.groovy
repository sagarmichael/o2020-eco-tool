package eco.tool


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EcoToolValuesController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EcoToolValues.list(params), model: [ecoToolValuesInstanceCount: EcoToolValues.count()]
    }

    def show(EcoToolValues ecoToolValuesInstance) {
        respond ecoToolValuesInstance
    }

    def create() {
        respond new EcoToolValues(params)
    }

    @Transactional
    def save(EcoToolValues ecoToolValuesInstance) {
        if (ecoToolValuesInstance == null) {
            notFound()
            return
        }

        if (ecoToolValuesInstance.hasErrors()) {
            respond ecoToolValuesInstance.errors, view: 'create'
            return
        }

        ecoToolValuesInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ecoToolValues.label', default: 'EcoToolValues'), ecoToolValuesInstance.id])
                redirect ecoToolValuesInstance
            }
            '*' { respond ecoToolValuesInstance, [status: CREATED] }
        }
    }

    def edit(EcoToolValues ecoToolValuesInstance) {
        respond ecoToolValuesInstance
    }

    @Transactional
    def update(EcoToolValues ecoToolValuesInstance) {
        if (ecoToolValuesInstance == null) {
            notFound()
            return
        }

        if (ecoToolValuesInstance.hasErrors()) {
            respond ecoToolValuesInstance.errors, view: 'edit'
            return
        }

        ecoToolValuesInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'EcoToolValues.label', default: 'EcoToolValues'), ecoToolValuesInstance.id])
                redirect ecoToolValuesInstance
            }
            '*' { respond ecoToolValuesInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(EcoToolValues ecoToolValuesInstance) {

        if (ecoToolValuesInstance == null) {
            notFound()
            return
        }

        ecoToolValuesInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'EcoToolValues.label', default: 'EcoToolValues'), ecoToolValuesInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ecoToolValues.label', default: 'EcoToolValues'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
