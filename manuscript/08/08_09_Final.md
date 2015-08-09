# Final Variables{#chfinal}

The `final` modifier

{lang=groovy}
<<[Using `final`](code/08/09/final.groovy)


{lang=groovy}
<<[Setting a `final` member variable via the constructor](code/08/09/final_constructor.groovy)

Be warned with the map-based approach to creating new instances as they don't really call a special constructor and
won't work against `final` properties.

But for collections....

{lang=groovy}
<<[This may surprise you](code/08/09/collection.groovy)

This will stop Duncan:

{lang=groovy}
<<[Really make that collection final](code/08/09/immutable.groovy)

