package com.jerrykel.fackeperson.models

class FakeGeneratorResults(var results: Array<FakeProfile>) {
    public fun getResult():FakeProfile{
        return results[0];
    }
}