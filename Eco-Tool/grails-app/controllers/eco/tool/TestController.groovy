package eco.tool

class TestController {

    def commandsService
    def index() {
        params.put("counties", ["spain","portugal","france","belguim","united kingdom","slovenia","switzerland"])
        params.put("lens","spain")
        params.put("frontal","belguim")
        params.put("temple","united kingdom")
        params
    }
    def test()
    {
        params.put("counties", ["spain","portugal","france","belguim","united kingdom","slovenia","switzerland"])
        params.operation1 = commandsService.operation1()
        params.operation2 = commandsService.operation2(params)
        params.operation3 = commandsService.operation3()
        params.operation4 = commandsService.operation8(params)
        params.operation5 = commandsService.operation5()
        params.operation6 = commandsService.operation6(params)
        if(!params.ti) {
            params.operation7 = commandsService.operation7(params)
            params.operation8 = commandsService.operation8(params)
            params.operation9 = commandsService.operation9(params)
            params.operation10 = commandsService.operation10(params)
            params.operation11 = commandsService.operation11(params)
            params.operation12 = commandsService.operation12(params)
        }
        params.operation13 = commandsService.operation13(params)
        params.operation14 = commandsService.operation14(params)
        params.operation15 = commandsService.operation15(params)
        params.operation16 = commandsService.operation16(params)
        params.operation17 = commandsService.operation17(params)
        params.operation18 = commandsService.operation18(params)
        if(params.ti) {
            params.operation19 = commandsService.operation19(params)
            params.operation20 = commandsService.operation20(params)
            params.operation21 = commandsService.operation21(params)
            params.operation22 = commandsService.operation22(params)
        }
        params.operation23 = commandsService.operation23(params)
        params.operation24 = commandsService.operation24(params)
        params.operation25 = commandsService.operation25(params)
        params.operation26 = commandsService.operation26()
        params.operation27 = commandsService.operation27(params)
        chain(action:"index", model:[params:params])
    }

}
