class 4352 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect8
		AttachOn=AM_LA
		bUseCharacterRotation=True
		offset=(X=0.000000,Y=0.000000,Z=1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.bl_berserker_spirit_ta'
		bOnMultiTarget=True
	End Object
	Desc="아지트 버저커 스피릿" //Berserker Spirit hideout
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect8',SpecificStage=0)
}