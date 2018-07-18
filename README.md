# MT assumptions

## @WithoutTenant should work on class

### Why?

Documentation in class says so:
```
 * <p>An AST transformation that makes a particular class or method execute without a tenant id. For example:</p>
```

### Example

See: `WithoutController`

```
Caused by: groovy.lang.MissingPropertyException: No such property: tenantId for class: mttests.WithoutController
```

Expected no error.

## @CurrentTenant never has affect on app

### Why?

Due to the `MultiTenantEventListener` in combination with `@WithoutTenant` not working on a class, `@CurrrentTenant` will never change the behavior of an app.

Due to this I don't see a scenario where `@CurrentTenant` could effectively be used.


### Example

See: `CurrentController`

Expect these to have different results, but are the same.

* http://localhost:8080/current/with
* http://localhost:8080/current/none

### Example 2

See: `CurrentController`

`serviceWith()` & `serviceWithOut()` have the same results even though the service methods are annotated differently.


## MultiTenantEventListener is applied everywhere

### Why?

Similar to the previous assumption If a class does not have any tenant annotations/blocks I assume it will not use any MT features.

Note this may be a bad assumption now, but the docs should be updated to illustrate this.

### Examples

See: `NotawareController` & `TenantService`
* http://localhost:8080/notaware/index // MT filter applied, expected not
* http://localhost:8080/notaware/service // MT filter applied, expected not