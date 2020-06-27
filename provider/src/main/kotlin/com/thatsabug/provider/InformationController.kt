package com.thatsabug.provider


import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class InformationController {
    @RequestMapping("/information")
    fun information(@RequestParam(value = "name", defaultValue = "linkedin") name: String?): Information? {
        return getSpongeBobData()
    }

    private fun getSpongeBobData(): Information {
        return Information(
                "SpongeBob SquarePants",
                "PhD2",
                "Complex Quantum Mechanics; Cooking; Philanthropy",
                null,
                null,
                "24",
                "Harold SquarePants; Margaret SquarePants"
        )
    }
}