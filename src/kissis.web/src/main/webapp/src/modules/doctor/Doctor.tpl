<div id="book-header">
    <nav class="navbar navbar-default navbar-fixed-top" style="height:50px">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="home.html"><img src="SWCIsantander.png" alt="citas santander" style="width:150px;margin-top:-10px"></a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="index.html">Inicio</a></li>
                    <li><a href="doctores.html">Doctores</a></li>
                    <li><a href="serviciosPaciente.html">Servicios</a></li>
                    <li><a href="contactenos.html">Contáctanos</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><img src="imagenesPaginas/fotoDePerfil.jpg" alt="some_text" style="width:50px;height:40px;margin:4px"></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">Alberto Consuegra<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="perfilDoctor.html"><span class="glyphicon glyphicon-user"></span> Mi Perfil</a></li>
                            <li><a href="index.html"><span class="glyphicon glyphicon-remove"></span> Cerrar Sesion</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>

<div ng-show="ctrl.verPerfil">
    <div class="clear"><br></div>
    <div class="clear"><br></div>
    <div class="clear"><br></div>

    <div class="container" style="width:1018px">
        <div class="col-md-9" style="border-right: 1px solid #90DA11">
            <h2>Consultorio #</h2>
            <a ng-href="{{currentRecord.image}}" target="_blank"><img class="img-responsive" style="height: 270px;width:420px" ng-src="{{currentRecord.image}}" alt="{{currentRecord.image}}"></a>

            <br>
            <br>
            <div class="col-md-4" style="padding:0px"><b>Especialidad:</b></div><div class="col-md-5">{{currentRecord.especialidad}}</div>
            <br>
            <br>
            <div class="col-md-4" style="padding:0px"><b>Id. de Consultorio:</b></div><div class="col-md-5">{{currentRecord.id}}</div>
            <br>
            <br>
            <div class="col-md-4" style="padding:0px"><b>Tipo de Consultorio:</b></div><div class="col-md-5">{{currentRecord.tipo}}</div>
            <br>
            <br>
            <div class="col-md-4" style="padding:0px"><b>Estensión:</b></div><div class="col-md-5">{{currentRecord.extension}}</div>
            <br>
            <br>
            <div class="col-md-4" style="padding:0px"><b>Tamaño:</b></div><div class="col-md-5">{{currentRecord.tamanio}}</div>
            <br>
            <br>


            <button ng-click="ctrl.editRecord(currentRecord)" class="btn btn-default">Editar</button>
            <button ng-click="ctr.deleteRecord(currentRecord)" class="btn btn-default">Eliminar</button>

        </div><!-- end content -->

    </div>
</div>
<div ng-show="ctrl.editMode">

    <div class="clear"><br></div>
    <div class="clear"><br></div>
    <div class="clear"><br></div>

    <div class="container" style="width:1018px">
        <div class="col-md-9" style="border-right: 1px solid #90DA11">
            <h2>Agregar Consultorio</h2>
            <form novalidate name="form" id="book-form" role="form" ng-submit="form.$valid && ctrl.saveRecord()">
                <fieldset>
                    <input id="id" class="form-control" type="hidden" ng-model="currentRecord.id"/>

                    <div class="col-md-4" style="padding:0px"><b>Ruta imágen:</b></div>
                    <div class="col-md-5"><input type="text" name="consultorioImage" style="height:25px" class="form-control"  ng-model="currentRecord.image" required></div>
                    <br>
                    <br>
                    <div class="col-md-4" style="padding:0px"><b>Especialidad:</b></div>
                    <div class="col-md-5"> 
                        <select name="Especialidad" id="Especialidad" style="height:25px"  class="form-control"  ng-model="currentRecord.especialidad" required>
                            <option value=""></option>
                            <option value="Medicina General">Medicina General</option>
                            <option value ="Audiologia">Audiología</option>
                            <option value = "Dermatologia">Dermatología</option>
                            <option value="Ginecologia">Ginecología</option>
                            <option value="Oftalmologia">Oftamología</option>
                            <option value="Reumatologia">Reumatología</option>
                            <option value="Urologia">Urología</option>
                            <option value="Pediatria">Pediatría</option>
                            <option value="Ecografia">Ecografía</option>
                        </select>
                    </div>
                    <br>
                    <br>
                    <div class="col-md-4" style="padding:0px"><b>Id. de Consultorio:</b></div>
                    <div class="col-md-5"><input type="text" name="ConsultorioID" value="ConsultorioID" style="height:25px" class="form-control"  ng-model="currentRecord.id" required></div>
                    <br>
                    <br>
                    <div class="col-md-4" style="padding:0px"><b>Tipo de Consultorio:</b></div>
                    <div class="col-md-5"> <select name="TipoConsultorio" id="TipoConsultorio" style="height:25px" class="form-control"  ng-model="currentRecord.tipo" required>
                            <option value="Consultas">Consultas</option>
                            <option value="Sala de Cirugia">Sala de Cirugia</option>
                            <option value="Terapia">Terapia</option>
                            <option value="Radiologia">Radiología</option>
                        </select>
                    </div>
                    <br>
                    <br>
                    <div class="col-md-4" style="padding:0px"><b>Extensión del Consultorio:</b></div>
                    <div class="col-md-5"><input type="text" name="noIdentificacion" value="2035" style="height:25px"  class="form-control"  ng-model="currentRecord.extension" required></div>
                    <br>
                    <br>
                    <div class="col-md-4" style="padding:0px"><b>Tamaño:</b></div>
                    <div class="col-md-5"> <select name="Genero" id="Genero" style="height:25px" class="form-control"  ng-model="currentRecord.tamanio" required>
                            <option value="Grande">Grande</option>
                            <option value="Mediano">Mediano</option>
                            <option value="Pequeño">Pequeño</option>
                        </select>
                    </div>
                    <br>
                    <br>

                </fieldset>

            </form>
            
            <button ng-click="ctrl.saveRecord();" id="save-book" type="submit" form="book-form" class="btn btn-default"><span class="glyphicon glyphicon-save"></span> Guardar</button>
            <button ng-click="form.$setPristine();
                        ctrl.fetchRecords();" type="submit" class="btn btn-default" value="Cancelar" style="float:left;font-family:Tahoma,Geneva,sans-serif">cancel</button>

        </div>

    </div>

    <div ng-show="ctrl.verHorarios">
        <div class="clear"><br></div>
        <div class="clear"><br></div>
        <div class="clear"><br></div>

        <div class="container" style="width:1018px">
            <div class="col-md-9" style="border-right: 1px solid #90DA11">
                <h2>Consultorios actuales</h2>

                <br>

                <img src ="ModernRoom.png" alt="Foto de perfil" style="width:420px;height:270px;">
                <br>
                <br>


                <div class="list-group" ng-repeat="record in records">
                    <a ng-click="ctrl.fetchRecord(record);" href="#" class="list-group-item">Consultorio {{record.id}}</a>
                </div>
                <br>

                <div class="col-md-8"><input type="text" name="consultorioBuscar" value="Ingrese el Id o nombre del consultorio." style="height:25px"></div>

                
            </div>
        </div>
</div>
        <div id="sidebar">
            <div class="col-md-3 sidebar">
                <h4 style="text-align:right">Mi Menu</h4>
                <table>
                    <tr>
                    <a href="perfilAdministrador.html"><input type="submit" value="Mi Perfil" style="margin:10px;float:left;font-family:Tahoma,Geneva,sans-serif;width:96%"/></a>
                    </tr>

                    <tr>
                    <a href="agregarMedico.html"><input type="submit" value="Agregar Medico" style="margin:10px;float:left;font-family:Tahoma,Geneva,sans-serif;width:96%"/></a>
                    </tr>

                    <tr>
                    <a href="agregarConsultorio.html"><input type="submit" value="Agregar Consultorio" style="margin:10px;float:left;font-family:Tahoma,Geneva,sans-serif;width:96%"/></a>
                    </tr>

                    <tr>
                    <a href="ManejadorConsultorios.html"><input type="submit" value="Consultorios" style="margin:10px;float:left;font-family:Tahoma,Geneva,sans-serif;width:96%"/></a>
                    </tr>

                    <tr>
                    <a href=""><input type="submit" value="Medicos" style="margin:10px;float:left;font-family:Tahoma,Geneva,sans-serif;width:96%"/></a>
                    </tr>

                    <tr>
                    <a href="CambiarContraseña.html"><input type="submit" value="Cambiar Contraseña" style="margin:10px;float:left;font-family:Tahoma,Geneva,sans-serif;width:96%"/></a>
                    </tr>

                </table>
            </div><!-- end sidebar -->

        </div><!-- end main -->



        <div class="clear"><br></div>

        <div id="footer">
            <p>&copy; YourSite 2011. Design by <a href="http://www.electrictowelrail.org.uk" target="_blank">Electric Towel Rail</a>  | <a href="http://validator.w3.org/check/referer" title="This page validates as XHTML 1.0 Transitional"><abbr title="eXtensible HyperText Markup Language">XHTML</abbr></a> | <a href="http://jigsaw.w3.org/css-validator/check/referer" title="This page validates as CSS"><abbr title="Cascading Style Sheets">CSS</abbr></a></p>
        </div><!-- end footer -->
    

