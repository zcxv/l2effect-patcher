class 2011 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect23
		AttachOn=AM_LA
		bSpawnOnTarget=True
		bSizeScale=True
		EffectClass=Class'LineageEffect.it_quick_step_potion_ta'
	End Object
	Desc="이동속도향상물약" //Potion movement speed
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect23',SpecificStage=0)
}