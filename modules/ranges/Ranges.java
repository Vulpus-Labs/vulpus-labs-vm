package com.vulpuslabs.ranges;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.vulpes.values.events.*;
import com.vulpuslabs.vulpes.modules.ranges.*;


//[/user-imports]


public class Ranges extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

   public Ranges( long moduleID, VoltageObjects voltageObjects )
   {
      super( moduleID, voltageObjects, "Ranges", ModuleType.ModuleType_Utility, 1.8 );

      InitializeControls();


      canBeBypassed = false;
      SetSkin( "5df5ad7a3c97459b95f713107201114c" );
   }

void InitializeControls()
{

      cvIn1 = new VoltageAudioJack( "cvIn1", "CV In 1", this, JackType.JackType_AudioInput );
      AddComponent( cvIn1 );
      cvIn1.SetWantsMouseNotifications( false );
      cvIn1.SetPosition( 4, 53 );
      cvIn1.SetSize( 25, 25 );
      cvIn1.SetSkin( "Jack Round Mint Ring" );

      cvIn2 = new VoltageAudioJack( "cvIn2", "CV In 2", this, JackType.JackType_AudioInput );
      AddComponent( cvIn2 );
      cvIn2.SetWantsMouseNotifications( false );
      cvIn2.SetPosition( 4, 85 );
      cvIn2.SetSize( 25, 25 );
      cvIn2.SetSkin( "Jack Round Mint Ring" );

      cvIn3 = new VoltageAudioJack( "cvIn3", "CV In 3", this, JackType.JackType_AudioInput );
      AddComponent( cvIn3 );
      cvIn3.SetWantsMouseNotifications( false );
      cvIn3.SetPosition( 4, 117 );
      cvIn3.SetSize( 25, 25 );
      cvIn3.SetSkin( "Jack Round Mint Ring" );

      addVoltage2 = new VoltageKnob( "addVoltage2", "Add Voltage 2", this, -5, 5, 0.0 );
      AddComponent( addVoltage2 );
      addVoltage2.SetWantsMouseNotifications( false );
      addVoltage2.SetPosition( 35, 86 );
      addVoltage2.SetSize( 25, 25 );
      addVoltage2.SetSkin( "Knurled Plastic Mint" );
      addVoltage2.SetRange( -5, 5, 0.0, false, 0 );
      addVoltage2.SetKnobParams( 215, 145 );
      addVoltage2.SetUnits( "v" );
      addVoltage2.DisplayValueInPercent( false );
      addVoltage2.SetKnobAdjustsRing( true );

      addVoltage1 = new VoltageKnob( "addVoltage1", "Add Voltage 1", this, -5, 5, 0.0 );
      AddComponent( addVoltage1 );
      addVoltage1.SetWantsMouseNotifications( false );
      addVoltage1.SetPosition( 35, 54 );
      addVoltage1.SetSize( 25, 25 );
      addVoltage1.SetSkin( "Knurled Plastic Mint" );
      addVoltage1.SetRange( -5, 5, 0.0, false, 0 );
      addVoltage1.SetKnobParams( 215, 145 );
      addVoltage1.SetUnits( "v" );
      addVoltage1.DisplayValueInPercent( false );
      addVoltage1.SetKnobAdjustsRing( true );

      addVoltage3 = new VoltageKnob( "addVoltage3", "Add Voltage 3", this, -5, 5, 0.0 );
      AddComponent( addVoltage3 );
      addVoltage3.SetWantsMouseNotifications( false );
      addVoltage3.SetPosition( 35, 118 );
      addVoltage3.SetSize( 25, 25 );
      addVoltage3.SetSkin( "Knurled Plastic Mint" );
      addVoltage3.SetRange( -5, 5, 0.0, false, 0 );
      addVoltage3.SetKnobParams( 215, 145 );
      addVoltage3.SetUnits( "v" );
      addVoltage3.DisplayValueInPercent( false );
      addVoltage3.SetKnobAdjustsRing( true );

      multiplyAmount1 = new VoltageKnob( "multiplyAmount1", "Multiply Amount 1", this, -1, 1, 1 );
      AddComponent( multiplyAmount1 );
      multiplyAmount1.SetWantsMouseNotifications( false );
      multiplyAmount1.SetPosition( 66, 54 );
      multiplyAmount1.SetSize( 25, 25 );
      multiplyAmount1.SetSkin( "Knurled Plastic Sky" );
      multiplyAmount1.SetRange( -1, 1, 1, false, 0 );
      multiplyAmount1.SetKnobParams( 215, 145 );
      multiplyAmount1.DisplayValueInPercent( true );
      multiplyAmount1.SetKnobAdjustsRing( true );

      multiplyAmount2 = new VoltageKnob( "multiplyAmount2", "Multiply Amount 2", this, -1, 1, 1 );
      AddComponent( multiplyAmount2 );
      multiplyAmount2.SetWantsMouseNotifications( false );
      multiplyAmount2.SetPosition( 66, 86 );
      multiplyAmount2.SetSize( 25, 25 );
      multiplyAmount2.SetSkin( "Knurled Plastic Sky" );
      multiplyAmount2.SetRange( -1, 1, 1, false, 0 );
      multiplyAmount2.SetKnobParams( 215, 145 );
      multiplyAmount2.DisplayValueInPercent( true );
      multiplyAmount2.SetKnobAdjustsRing( true );

      multiplyAmount3 = new VoltageKnob( "multiplyAmount3", "Multiply Amount 3", this, -1, 1, 1 );
      AddComponent( multiplyAmount3 );
      multiplyAmount3.SetWantsMouseNotifications( false );
      multiplyAmount3.SetPosition( 66, 118 );
      multiplyAmount3.SetSize( 25, 25 );
      multiplyAmount3.SetSkin( "Knurled Plastic Sky" );
      multiplyAmount3.SetRange( -1, 1, 1, false, 0 );
      multiplyAmount3.SetKnobParams( 215, 145 );
      multiplyAmount3.DisplayValueInPercent( true );
      multiplyAmount3.SetKnobAdjustsRing( true );

      cvOut2 = new VoltageAudioJack( "cvOut2", "CV Out 2", this, JackType.JackType_AudioOutput );
      AddComponent( cvOut2 );
      cvOut2.SetWantsMouseNotifications( false );
      cvOut2.SetPosition( 97, 85 );
      cvOut2.SetSize( 25, 25 );
      cvOut2.SetSkin( "Jack Round Sky Ring" );

      cvOut1 = new VoltageAudioJack( "cvOut1", "CV Out 1", this, JackType.JackType_AudioOutput );
      AddComponent( cvOut1 );
      cvOut1.SetWantsMouseNotifications( false );
      cvOut1.SetPosition( 97, 53 );
      cvOut1.SetSize( 25, 25 );
      cvOut1.SetSkin( "Jack Round Sky Ring" );

      cvOut3 = new VoltageAudioJack( "cvOut3", "CV Out 3", this, JackType.JackType_AudioOutput );
      AddComponent( cvOut3 );
      cvOut3.SetWantsMouseNotifications( false );
      cvOut3.SetPosition( 97, 117 );
      cvOut3.SetSize( 25, 25 );
      cvOut3.SetSkin( "Jack Round Sky Ring" );

      textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "IN" );
      AddComponent( textLabel3 );
      textLabel3.SetWantsMouseNotifications( false );
      textLabel3.SetPosition( 2, 32 );
      textLabel3.SetSize( 30, 15 );
      textLabel3.SetEditable( false, false );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel3.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel3.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel3.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel3.SetBorderSize( 1 );
      textLabel3.SetMultiLineEdit( false );
      textLabel3.SetIsNumberEditor( false );
      textLabel3.SetNumberEditorRange( 0, 100 );
      textLabel3.SetNumberEditorInterval( 1 );
      textLabel3.SetNumberEditorUsesMouseWheel( false );
      textLabel3.SetHasCustomTextHoverColor( false );
      textLabel3.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel3.SetFont( "Arial", 10, true, false );

      textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "ADD" );
      AddComponent( textLabel4 );
      textLabel4.SetWantsMouseNotifications( false );
      textLabel4.SetPosition( 33, 32 );
      textLabel4.SetSize( 30, 15 );
      textLabel4.SetEditable( false, false );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel4.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel4.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel4.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel4.SetBorderSize( 1 );
      textLabel4.SetMultiLineEdit( false );
      textLabel4.SetIsNumberEditor( false );
      textLabel4.SetNumberEditorRange( 0, 100 );
      textLabel4.SetNumberEditorInterval( 1 );
      textLabel4.SetNumberEditorUsesMouseWheel( false );
      textLabel4.SetHasCustomTextHoverColor( false );
      textLabel4.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel4.SetFont( "Arial", 10, true, false );

      textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "MUL" );
      AddComponent( textLabel5 );
      textLabel5.SetWantsMouseNotifications( false );
      textLabel5.SetPosition( 64, 32 );
      textLabel5.SetSize( 30, 15 );
      textLabel5.SetEditable( false, false );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel5.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel5.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel5.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel5.SetBorderSize( 1 );
      textLabel5.SetMultiLineEdit( false );
      textLabel5.SetIsNumberEditor( false );
      textLabel5.SetNumberEditorRange( 0, 100 );
      textLabel5.SetNumberEditorInterval( 1 );
      textLabel5.SetNumberEditorUsesMouseWheel( false );
      textLabel5.SetHasCustomTextHoverColor( false );
      textLabel5.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel5.SetFont( "Arial", 10, true, false );

      textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "OUT" );
      AddComponent( textLabel6 );
      textLabel6.SetWantsMouseNotifications( false );
      textLabel6.SetPosition( 95, 32 );
      textLabel6.SetSize( 30, 15 );
      textLabel6.SetEditable( false, false );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel6.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel6.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel6.SetBorderSize( 1 );
      textLabel6.SetMultiLineEdit( false );
      textLabel6.SetIsNumberEditor( false );
      textLabel6.SetNumberEditorRange( 0, 100 );
      textLabel6.SetNumberEditorInterval( 1 );
      textLabel6.SetNumberEditorUsesMouseWheel( false );
      textLabel6.SetHasCustomTextHoverColor( false );
      textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel6.SetFont( "Arial", 10, true, false );

      textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "RANGES" );
      AddComponent( textLabel1 );
      textLabel1.SetWantsMouseNotifications( false );
      textLabel1.SetPosition( 0, 0 );
      textLabel1.SetSize( 129, 15 );
      textLabel1.SetEditable( false, false );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel1.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel1.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel1.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel1.SetBorderSize( 1 );
      textLabel1.SetMultiLineEdit( false );
      textLabel1.SetIsNumberEditor( false );
      textLabel1.SetNumberEditorRange( 0, 100 );
      textLabel1.SetNumberEditorInterval( 1 );
      textLabel1.SetNumberEditorUsesMouseWheel( false );
      textLabel1.SetHasCustomTextHoverColor( false );
      textLabel1.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel1.SetFont( "Arial", 10, true, false );

      textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "VULPUS LABS" );
      AddComponent( textLabel2 );
      textLabel2.SetWantsMouseNotifications( false );
      textLabel2.SetPosition( 0, 345 );
      textLabel2.SetSize( 129, 15 );
      textLabel2.SetEditable( false, false );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel2.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel2.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel2.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel2.SetBorderSize( 1 );
      textLabel2.SetMultiLineEdit( false );
      textLabel2.SetIsNumberEditor( false );
      textLabel2.SetNumberEditorRange( 0, 100 );
      textLabel2.SetNumberEditorInterval( 1 );
      textLabel2.SetNumberEditorUsesMouseWheel( false );
      textLabel2.SetHasCustomTextHoverColor( false );
      textLabel2.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel2.SetFont( "Arial", 10, true, false );

      cvIn4 = new VoltageAudioJack( "cvIn4", "CV In 4", this, JackType.JackType_AudioInput );
      AddComponent( cvIn4 );
      cvIn4.SetWantsMouseNotifications( false );
      cvIn4.SetPosition( 4, 149 );
      cvIn4.SetSize( 25, 25 );
      cvIn4.SetSkin( "Jack Round Mint Ring" );

      addVoltage4 = new VoltageKnob( "addVoltage4", "Add Voltage 4", this, -5, 5, 0.0 );
      AddComponent( addVoltage4 );
      addVoltage4.SetWantsMouseNotifications( false );
      addVoltage4.SetPosition( 35, 150 );
      addVoltage4.SetSize( 25, 25 );
      addVoltage4.SetSkin( "Knurled Plastic Mint" );
      addVoltage4.SetRange( -5, 5, 0.0, false, 0 );
      addVoltage4.SetKnobParams( 215, 145 );
      addVoltage4.SetUnits( "v" );
      addVoltage4.DisplayValueInPercent( false );
      addVoltage4.SetKnobAdjustsRing( true );

      multiplyAmount4 = new VoltageKnob( "multiplyAmount4", "Multiply Amount 4", this, -1, 1, 1 );
      AddComponent( multiplyAmount4 );
      multiplyAmount4.SetWantsMouseNotifications( false );
      multiplyAmount4.SetPosition( 66, 150 );
      multiplyAmount4.SetSize( 25, 25 );
      multiplyAmount4.SetSkin( "Knurled Plastic Sky" );
      multiplyAmount4.SetRange( -1, 1, 1, false, 0 );
      multiplyAmount4.SetKnobParams( 215, 145 );
      multiplyAmount4.DisplayValueInPercent( true );
      multiplyAmount4.SetKnobAdjustsRing( true );

      cvOut4 = new VoltageAudioJack( "cvOut4", "CV Out 4", this, JackType.JackType_AudioOutput );
      AddComponent( cvOut4 );
      cvOut4.SetWantsMouseNotifications( false );
      cvOut4.SetPosition( 97, 149 );
      cvOut4.SetSize( 25, 25 );
      cvOut4.SetSkin( "Jack Round Sky Ring" );

      cvIn5 = new VoltageAudioJack( "cvIn5", "CV In 5", this, JackType.JackType_AudioInput );
      AddComponent( cvIn5 );
      cvIn5.SetWantsMouseNotifications( false );
      cvIn5.SetPosition( 4, 181 );
      cvIn5.SetSize( 25, 25 );
      cvIn5.SetSkin( "Jack Round Mint Ring" );

      addVoltage5 = new VoltageKnob( "addVoltage5", "Add Voltage 5", this, -5, 5, 0.0 );
      AddComponent( addVoltage5 );
      addVoltage5.SetWantsMouseNotifications( false );
      addVoltage5.SetPosition( 35, 182 );
      addVoltage5.SetSize( 25, 25 );
      addVoltage5.SetSkin( "Knurled Plastic Mint" );
      addVoltage5.SetRange( -5, 5, 0.0, false, 0 );
      addVoltage5.SetKnobParams( 215, 145 );
      addVoltage5.SetUnits( "v" );
      addVoltage5.DisplayValueInPercent( false );
      addVoltage5.SetKnobAdjustsRing( true );

      multiplyAmount5 = new VoltageKnob( "multiplyAmount5", "Multiply Amount 5", this, -1, 1, 1 );
      AddComponent( multiplyAmount5 );
      multiplyAmount5.SetWantsMouseNotifications( false );
      multiplyAmount5.SetPosition( 66, 182 );
      multiplyAmount5.SetSize( 25, 25 );
      multiplyAmount5.SetSkin( "Knurled Plastic Sky" );
      multiplyAmount5.SetRange( -1, 1, 1, false, 0 );
      multiplyAmount5.SetKnobParams( 215, 145 );
      multiplyAmount5.DisplayValueInPercent( true );
      multiplyAmount5.SetKnobAdjustsRing( true );

      cvOut5 = new VoltageAudioJack( "cvOut5", "CV Out 5", this, JackType.JackType_AudioOutput );
      AddComponent( cvOut5 );
      cvOut5.SetWantsMouseNotifications( false );
      cvOut5.SetPosition( 97, 181 );
      cvOut5.SetSize( 25, 25 );
      cvOut5.SetSkin( "Jack Round Sky Ring" );

      cvIn6 = new VoltageAudioJack( "cvIn6", "CV In 6", this, JackType.JackType_AudioInput );
      AddComponent( cvIn6 );
      cvIn6.SetWantsMouseNotifications( false );
      cvIn6.SetPosition( 4, 213 );
      cvIn6.SetSize( 25, 25 );
      cvIn6.SetSkin( "Jack Round Mint Ring" );

      addVoltage6 = new VoltageKnob( "addVoltage6", "Add Voltage 6", this, -5, 5, 0.0 );
      AddComponent( addVoltage6 );
      addVoltage6.SetWantsMouseNotifications( false );
      addVoltage6.SetPosition( 35, 214 );
      addVoltage6.SetSize( 25, 25 );
      addVoltage6.SetSkin( "Knurled Plastic Mint" );
      addVoltage6.SetRange( -5, 5, 0.0, false, 0 );
      addVoltage6.SetKnobParams( 215, 145 );
      addVoltage6.SetUnits( "v" );
      addVoltage6.DisplayValueInPercent( false );
      addVoltage6.SetKnobAdjustsRing( true );

      multiplyAmount6 = new VoltageKnob( "multiplyAmount6", "Multiply Amount 6", this, -1, 1, 1 );
      AddComponent( multiplyAmount6 );
      multiplyAmount6.SetWantsMouseNotifications( false );
      multiplyAmount6.SetPosition( 66, 214 );
      multiplyAmount6.SetSize( 25, 25 );
      multiplyAmount6.SetSkin( "Knurled Plastic Sky" );
      multiplyAmount6.SetRange( -1, 1, 1, false, 0 );
      multiplyAmount6.SetKnobParams( 215, 145 );
      multiplyAmount6.DisplayValueInPercent( true );
      multiplyAmount6.SetKnobAdjustsRing( true );

      cvOut6 = new VoltageAudioJack( "cvOut6", "CV Out 6", this, JackType.JackType_AudioOutput );
      AddComponent( cvOut6 );
      cvOut6.SetWantsMouseNotifications( false );
      cvOut6.SetPosition( 97, 213 );
      cvOut6.SetSize( 25, 25 );
      cvOut6.SetSkin( "Jack Round Sky Ring" );

      cvIn7 = new VoltageAudioJack( "cvIn7", "CV In 7", this, JackType.JackType_AudioInput );
      AddComponent( cvIn7 );
      cvIn7.SetWantsMouseNotifications( false );
      cvIn7.SetPosition( 4, 245 );
      cvIn7.SetSize( 25, 25 );
      cvIn7.SetSkin( "Jack Round Mint Ring" );

      addVoltage7 = new VoltageKnob( "addVoltage7", "Add Voltage 7", this, -5, 5, 0.0 );
      AddComponent( addVoltage7 );
      addVoltage7.SetWantsMouseNotifications( false );
      addVoltage7.SetPosition( 35, 246 );
      addVoltage7.SetSize( 25, 25 );
      addVoltage7.SetSkin( "Knurled Plastic Mint" );
      addVoltage7.SetRange( -5, 5, 0.0, false, 0 );
      addVoltage7.SetKnobParams( 215, 145 );
      addVoltage7.SetUnits( "v" );
      addVoltage7.DisplayValueInPercent( false );
      addVoltage7.SetKnobAdjustsRing( true );

      multiplyAmount7 = new VoltageKnob( "multiplyAmount7", "Multiply Amount 7", this, -1, 1, 1 );
      AddComponent( multiplyAmount7 );
      multiplyAmount7.SetWantsMouseNotifications( false );
      multiplyAmount7.SetPosition( 66, 246 );
      multiplyAmount7.SetSize( 25, 25 );
      multiplyAmount7.SetSkin( "Knurled Plastic Sky" );
      multiplyAmount7.SetRange( -1, 1, 1, false, 0 );
      multiplyAmount7.SetKnobParams( 215, 145 );
      multiplyAmount7.DisplayValueInPercent( true );
      multiplyAmount7.SetKnobAdjustsRing( true );

      cvOut7 = new VoltageAudioJack( "cvOut7", "CV Out 7", this, JackType.JackType_AudioOutput );
      AddComponent( cvOut7 );
      cvOut7.SetWantsMouseNotifications( false );
      cvOut7.SetPosition( 97, 245 );
      cvOut7.SetSize( 25, 25 );
      cvOut7.SetSkin( "Jack Round Sky Ring" );

      cvIn8 = new VoltageAudioJack( "cvIn8", "CV In 8", this, JackType.JackType_AudioInput );
      AddComponent( cvIn8 );
      cvIn8.SetWantsMouseNotifications( false );
      cvIn8.SetPosition( 4, 277 );
      cvIn8.SetSize( 25, 25 );
      cvIn8.SetSkin( "Jack Round Mint Ring" );

      addVoltage8 = new VoltageKnob( "addVoltage8", "Add Voltage 8", this, -5, 5, 0.0 );
      AddComponent( addVoltage8 );
      addVoltage8.SetWantsMouseNotifications( false );
      addVoltage8.SetPosition( 35, 278 );
      addVoltage8.SetSize( 25, 25 );
      addVoltage8.SetSkin( "Knurled Plastic Mint" );
      addVoltage8.SetRange( -5, 5, 0.0, false, 0 );
      addVoltage8.SetKnobParams( 215, 145 );
      addVoltage8.SetUnits( "v" );
      addVoltage8.DisplayValueInPercent( false );
      addVoltage8.SetKnobAdjustsRing( true );

      multiplyAmount8 = new VoltageKnob( "multiplyAmount8", "Multiply Amount 8", this, -1, 1, 1 );
      AddComponent( multiplyAmount8 );
      multiplyAmount8.SetWantsMouseNotifications( false );
      multiplyAmount8.SetPosition( 66, 278 );
      multiplyAmount8.SetSize( 25, 25 );
      multiplyAmount8.SetSkin( "Knurled Plastic Sky" );
      multiplyAmount8.SetRange( -1, 1, 1, false, 0 );
      multiplyAmount8.SetKnobParams( 215, 145 );
      multiplyAmount8.DisplayValueInPercent( true );
      multiplyAmount8.SetKnobAdjustsRing( true );

      cvOut8 = new VoltageAudioJack( "cvOut8", "CV Out 8", this, JackType.JackType_AudioOutput );
      AddComponent( cvOut8 );
      cvOut8.SetWantsMouseNotifications( false );
      cvOut8.SetPosition( 97, 277 );
      cvOut8.SetSize( 25, 25 );
      cvOut8.SetSkin( "Jack Round Sky Ring" );

      textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "IN" );
      AddComponent( textLabel7 );
      textLabel7.SetWantsMouseNotifications( false );
      textLabel7.SetPosition( 2, 309 );
      textLabel7.SetSize( 30, 15 );
      textLabel7.SetEditable( false, false );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel7.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel7.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel7.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel7.SetBorderSize( 1 );
      textLabel7.SetMultiLineEdit( false );
      textLabel7.SetIsNumberEditor( false );
      textLabel7.SetNumberEditorRange( 0, 100 );
      textLabel7.SetNumberEditorInterval( 1 );
      textLabel7.SetNumberEditorUsesMouseWheel( false );
      textLabel7.SetHasCustomTextHoverColor( false );
      textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel7.SetFont( "Arial", 10, true, false );

      textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "ADD" );
      AddComponent( textLabel8 );
      textLabel8.SetWantsMouseNotifications( false );
      textLabel8.SetPosition( 33, 309 );
      textLabel8.SetSize( 30, 15 );
      textLabel8.SetEditable( false, false );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel8.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel8.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel8.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel8.SetBorderSize( 1 );
      textLabel8.SetMultiLineEdit( false );
      textLabel8.SetIsNumberEditor( false );
      textLabel8.SetNumberEditorRange( 0, 100 );
      textLabel8.SetNumberEditorInterval( 1 );
      textLabel8.SetNumberEditorUsesMouseWheel( false );
      textLabel8.SetHasCustomTextHoverColor( false );
      textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel8.SetFont( "Arial", 10, true, false );

      textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "MUL" );
      AddComponent( textLabel9 );
      textLabel9.SetWantsMouseNotifications( false );
      textLabel9.SetPosition( 64, 309 );
      textLabel9.SetSize( 30, 15 );
      textLabel9.SetEditable( false, false );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel9.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel9.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel9.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel9.SetBorderSize( 1 );
      textLabel9.SetMultiLineEdit( false );
      textLabel9.SetIsNumberEditor( false );
      textLabel9.SetNumberEditorRange( 0, 100 );
      textLabel9.SetNumberEditorInterval( 1 );
      textLabel9.SetNumberEditorUsesMouseWheel( false );
      textLabel9.SetHasCustomTextHoverColor( false );
      textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel9.SetFont( "Arial", 10, true, false );

      textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "OUT" );
      AddComponent( textLabel10 );
      textLabel10.SetWantsMouseNotifications( false );
      textLabel10.SetPosition( 95, 309 );
      textLabel10.SetSize( 30, 15 );
      textLabel10.SetEditable( false, false );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel10.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel10.SetBorderSize( 1 );
      textLabel10.SetMultiLineEdit( false );
      textLabel10.SetIsNumberEditor( false );
      textLabel10.SetNumberEditorRange( 0, 100 );
      textLabel10.SetNumberEditorInterval( 1 );
      textLabel10.SetNumberEditorUsesMouseWheel( false );
      textLabel10.SetHasCustomTextHoverColor( false );
      textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel10.SetFont( "Arial", 10, true, false );
}



   //-------------------------------------------------------------------------------
   //  public void Initialize()

      //  Initialize will get called shortly after your module's constructor runs. You can use it to
      //  do any initialization that the auto-generated code doesn't handle.
   //-------------------------------------------------------------------------------
   @Override
   public void Initialize()
   {
      //[user-Initialize]   Add your own initialization code here
      controller = new Controller(
         RangeAdjuster.connect(eventConnector, cvIn1, cvOut1, addVoltage1, multiplyAmount1),
         RangeAdjuster.connect(eventConnector, cvIn2, cvOut2, addVoltage2, multiplyAmount2),
         RangeAdjuster.connect(eventConnector, cvIn3, cvOut3, addVoltage3, multiplyAmount3),
         RangeAdjuster.connect(eventConnector, cvIn4, cvOut4, addVoltage4, multiplyAmount4),
         RangeAdjuster.connect(eventConnector, cvIn5, cvOut5, addVoltage5, multiplyAmount5),
         RangeAdjuster.connect(eventConnector, cvIn6, cvOut6, addVoltage6, multiplyAmount6),
         RangeAdjuster.connect(eventConnector, cvIn7, cvOut7, addVoltage7, multiplyAmount7),
         RangeAdjuster.connect(eventConnector, cvIn8, cvOut8, addVoltage8, multiplyAmount8));


      //[/user-Initialize]
   }


   //-------------------------------------------------------------------------------
   //  public void Destroy()

      //  Destroy will get called just before your module gets deleted. You can use it to perform any
      //  cleanup that's not handled automatically by Java.
   //-------------------------------------------------------------------------------
   @Override
   public void Destroy()
   {
      super.Destroy();
      //[user-Destroy]   Add your own module-getting-deleted code here



      //[/user-Destroy]
   }


   //-------------------------------------------------------------------------------
   //  public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )

      //  Notify will get called when various events occur - control values changing, timers firing, etc.
   //-------------------------------------------------------------------------------
   @Override
   public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )
   {
      //[user-Notify]   Add your own notification handling code between this line and the notify-close comment
      switch( notification )
      {
         case Knob_Changed: {
            var wasChanged = eventHandler.onKnobValueChanged(component, doubleValue);
            return wasChanged;
         }
      
         case Slider_Changed:   // doubleValue is the new slider value
         {
         }
         break;
      
         case Button_Changed:   // doubleValue is the new button/toggle button value
         {
         }
         break;
      
         case Switch_Changed:   // doubleValue is the new switch value
         {
         }
         break;
      
         case Jack_Connected: return eventHandler.onJackConnected(component);
      
         case Jack_Disconnected:return eventHandler.onJackDisconnected(component);
      
         case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
         {
         }
         break;
      
         case Object_MouseMove:   // called when mouse is over an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_MouseLeave:  // called when mouse leaves an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_LeftButtonDown:   // called when user left-clicks on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_LeftButtonUp:   // called when user releases left mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_RightButtonDown:   // called when user releases right mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_RightButtonUp:   // called when user right-clicks on an object that receives mouse notifications
         {
         }
         break;
      
         case Object_LeftButtonDoubleClick: // called when user left-button double-clicks on an object that receives mouse notifications
         {
         }
         break;
      
         // Less common notifications:
      
         case Named_Timer:   // object contains a String with the name of the timer that has fired
         {
         }
         break;
      
         case Canvas_Painting:   // About to paint canvas.  object is a java.awt.Rectangle with painting boundaries
         {
         }
         break;
      
         case Canvas_Painted:   // Canvas painting is complete
         {
         }
         break;
      
         case Control_DragStart:    // A user has started dragging on a control that has been marked as draggable
         {
         }
         break;
      
         case Control_DragOn:       // This control has been dragged over during a drag operation. object contains the dragged object
         {
         }
         break;
      
         case Control_DragOff:      // This control has been dragged over during a drag operation. object contains the dragged object
         {
         }
         break;
      
         case Control_DragEnd:      // A user has ended their drag on a control that has been marked as draggable
         {
         }
         break;
      
         case Label_Changed:        // The text of an editable text control has changed
         {
         }
         break;
      
         case SoundPlayback_Start:   // A sound has begun playback
         {
         }
         break;
      
         case SoundPlayback_End:     // A sound has ended playback
         {
         }
         break;
      
         case Scrollbar_Position:    // longValue is the new scrollbar position
         {
         }
         break;
      
         case PolyVoices_Changed:    // longValue is the new number of poly voices
         {
         }
         break;
      
         case File_Dropped:     // 'object' is a String containing the file path
         {
         }
         break;
      
         case Preset_Loading_Start:   // called when preset loading begins
         {
         }
         break;
      
         case Preset_Loading_Finish:  // called when preset loading finishes
         {
         }
         break;
      
         case Variation_Loading_Start:    // sent when a variation is about to load
         {
         }
         break;
      
         case Variation_Loading_Finish:   // sent when a variation has just finished loading
         {
         }
         break;
      
         case Tempo_Changed:     // doubleValue is the new tempo
         {
         }
         break;
      
         case Randomized:     // called when the module's controls get randomized
         {
         }
         break;
      
         case VariationListChanged:   // sent when a variation gets added, deleted, or renamed, or the variations list gets reordered
         {
         }
         break;
      
         case Key_Press:     // sent when module has keyboard focus and a key is pressed; object is a VoltageKeyPressInfo object
         {
         }
         break;
      
         case Reset:    // sent when the module has been reset to default settings
         {
         }
         break;
      
         case Keyboard_NoteOn:   // sent when a note has been pressed on a VoltageKeyboard object. longValue is the note value ( 0-127 )
         {
         }
         break;
      
         case Keyboard_NoteOff:   // sent when a note has been released on a VoltageKeyboard object. longValue is the note value ( 0-127 )
         {
         }
         break;
      
         case Curve_Changed:   // sent when user has edited a curve's value. 'object' will be a VoltageCurve.CurveChangeNotification object.
         {
         }
         break;
      }



      return false;
      //[/user-Notify]
   }


   //-------------------------------------------------------------------------------
   //  public void ProcessSample()

      //  ProcessSample is called once per sample. Usually it's where you read
      //  from input jacks, process audio, and write it to your output jacks.
      //  Since ProcesssSample gets called 48,000 times per second, offload CPU-intensive operations
      //  to other threads when possible and avoid calling native functions.
   //-------------------------------------------------------------------------------
   @Override
   public void ProcessSample()
   {
      //[user-ProcessSample]   Add your own process-sampling code here
      controller.processSample();


      //[/user-ProcessSample]
   }


   //-------------------------------------------------------------------------------
   //  public String GetTooltipText( VoltageComponent component )

      //  Gets called when a tooltip is about to display for a control. Override it if
      //  you want to change what the tooltip displays - if you want a knob to work in logarithmic fashion,
      //  for instance, you can translate the knob's current value to a log-based string and display it here.
   //-------------------------------------------------------------------------------
   @Override
   public String GetTooltipText( VoltageComponent component )
   {
      //[user-GetTooltipText]   Add your own code here



      return super.GetTooltipText( component );
      //[/user-GetTooltipText]
   }


   //-------------------------------------------------------------------------------
   //  public void EditComponentValue( VoltageComponent component, double newValue, String newText )

      //  Gets called after a user clicks on a tooltip and types in a new value for a control. Override this if
      //  you've changed the default tooltip display (translating a linear value to logarithmic, for instance)
      //  in GetTooltipText().
   //-------------------------------------------------------------------------------
   @Override
   public void EditComponentValue( VoltageComponent component, double newValue, String newText )
   {
      //[user-EditComponentValue]   Add your own code here



      //[/user-EditComponentValue]
      super.EditComponentValue( component, newValue, newText );
   }


   //-------------------------------------------------------------------------------
   //  public void OnUndoRedo( String undoType, double newValue, Object optionalObject )

      //  If you've created custom undo events via calls to CreateUndoEvent, you'll need to
      //  process them in this function when they get triggered by undo/redo actions.
   //-------------------------------------------------------------------------------
   @Override
   public void OnUndoRedo( String undoType, double newValue, Object optionalObject )
   {
      //[user-OnUndoRedo]   Add your own code here



      //[/user-OnUndoRedo]
   }


   //-------------------------------------------------------------------------------
   //  public byte[] GetStateInformation()

      //  Gets called when the module's state gets saved, typically when the user saves a preset with
      //  this module in it. Voltage Modular will automatically save the states of knobs, sliders, etc.,
      //  but if you have any custom state information you need to save, return it from this function.
   //-------------------------------------------------------------------------------
   @Override
   public byte[] GetStateInformation()
   {
      //[user-GetStateInformation]   Add your own code here



      return null;
      //[/user-GetStateInformation]
   }


   //-------------------------------------------------------------------------------
   //  public void SetStateInformation(byte[] stateInfo)

      //  Gets called when this module's state is getting restored, typically when a user opens a preset with
      //  this module in it. The stateInfo parameter will contain whatever custom data you stored in GetStateInformation().
   //-------------------------------------------------------------------------------
   @Override
   public void SetStateInformation(byte[] stateInfo)
   {
      //[user-SetStateInformation]   Add your own code here



      //[/user-SetStateInformation]
   }


   //-------------------------------------------------------------------------------
   //  public byte[] GetStateInformationForVariations()

      //  Gets called when a user saves a variation with this module in it.
      //  Voltage Modular will automatically save the states of knobs, sliders, etc.,
      //  but if you have any custom state information you need to save, return it from this function.
   //-------------------------------------------------------------------------------
   @Override
   public byte[] GetStateInformationForVariations()
   {
      //[user-GetStateInformationForVariations]   Add your own code here



      return GetStateInformation();
      //[/user-GetStateInformationForVariations]
   }


   //-------------------------------------------------------------------------------
   //  public void SetStateInformationForVariations(byte[] stateInfo)

      //  Gets called when a user loads a variation with this module in it.
      //  The stateInfo parameter will contain whatever custom data you stored in GetStateInformationForVariations().
   //-------------------------------------------------------------------------------
   @Override
   public void SetStateInformationForVariations(byte[] stateInfo)
   {
      //[user-SetStateInformationForVariations]   Add your own code here
      SetStateInformation(stateInfo);



      //[/user-SetStateInformationForVariations]
   }


   // Auto-generated variables
   private VoltageLabel textLabel10;
   private VoltageLabel textLabel9;
   private VoltageLabel textLabel8;
   private VoltageLabel textLabel7;
   private VoltageAudioJack cvOut8;
   private VoltageKnob multiplyAmount8;
   private VoltageKnob addVoltage8;
   private VoltageAudioJack cvIn8;
   private VoltageAudioJack cvOut7;
   private VoltageKnob multiplyAmount7;
   private VoltageKnob addVoltage7;
   private VoltageAudioJack cvIn7;
   private VoltageAudioJack cvOut6;
   private VoltageKnob multiplyAmount6;
   private VoltageKnob addVoltage6;
   private VoltageAudioJack cvIn6;
   private VoltageAudioJack cvOut5;
   private VoltageKnob multiplyAmount5;
   private VoltageKnob addVoltage5;
   private VoltageAudioJack cvIn5;
   private VoltageAudioJack cvOut4;
   private VoltageKnob multiplyAmount4;
   private VoltageKnob addVoltage4;
   private VoltageAudioJack cvIn4;
   private VoltageLabel textLabel2;
   private VoltageLabel textLabel1;
   private VoltageLabel textLabel6;
   private VoltageLabel textLabel5;
   private VoltageLabel textLabel4;
   private VoltageLabel textLabel3;
   private VoltageAudioJack cvOut3;
   private VoltageAudioJack cvOut1;
   private VoltageAudioJack cvOut2;
   private VoltageKnob multiplyAmount3;
   private VoltageKnob multiplyAmount2;
   private VoltageKnob multiplyAmount1;
   private VoltageKnob addVoltage3;
   private VoltageKnob addVoltage1;
   private VoltageKnob addVoltage2;
   private VoltageAudioJack cvIn3;
   private VoltageAudioJack cvIn2;
   private VoltageAudioJack cvIn1;


   //[user-code-and-variables]    Add your own variables and functions here
private Controller controller;
private final EventBus eventBus = new EventBus();
private final UIEventConnector eventConnector = new UIEventConnector(eventBus);
private final UIEventHandler eventHandler = new UIEventHandler(eventBus);




   //[/user-code-and-variables]
}

 