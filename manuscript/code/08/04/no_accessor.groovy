class Person {
    def id
    def name
    def email
    def mobile

    /**
     * Will NOT set the ID - do not call
     * @throws Exception Always throws an exception
     */
    private void setId(id) throws Exception {
        throw new Exception('Method not available')
    }
}
